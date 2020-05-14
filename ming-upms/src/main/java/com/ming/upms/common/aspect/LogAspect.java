package com.ming.upms.common.aspect;


import com.ming.upms.common.annotation.Log;
import com.ming.upms.common.util.HttpContextUtils;
import com.ming.upms.common.util.IPUtils;
import com.ming.upms.common.util.JSONUtils;
import com.ming.upms.common.util.ShiroUtils;
import com.ming.upms.system.domain.UpmsLogDO;
import com.ming.upms.system.domain.UpmsUserDO;
import com.ming.upms.system.service.UpmsLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    UpmsLogService logService;


    @Pointcut("@annotation(com.ming.upms.common.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志
        saveLog(point, time);
        return result;
    }

    void saveLog(ProceedingJoinPoint joinPoint, long time) throws InterruptedException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        UpmsLogDO sysLog = new UpmsLogDO();
        Log syslog = method.getAnnotation(Log.class);
        if (syslog != null) {
            // 注解上的描述
            sysLog.setDescription(syslog.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            if (args != null && args[0] != null) {
                String params = JSONUtils.beanToJson(args[0]);
                params = params.substring(0, params.length() < 5000 ? params.length() - 1 : 4999);
                sysLog.setPermissions(params);
            }
        } catch (Exception e) {
            logger.error("error: "+ e.getMessage(),e);
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));
        // 用户名
        UpmsUserDO currUser = ShiroUtils.getUser();
        if (null == currUser) {
            if (null != sysLog.getParameter()) {
                sysLog.setUsername(sysLog.getParameter());
            } else {
                sysLog.setUsername("获取用户信息为空");
            }
        } else {
            sysLog.setUsername(ShiroUtils.getUser().getUsername());
        }
        sysLog.setSpendTime((int) time);
        // 系统当前时间
        Date date = new Date();
        sysLog.setStartTime(date);
        // 保存系统日志
        logService.save(sysLog);
    }
}