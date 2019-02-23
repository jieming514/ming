package com.ming.common.aspect;

import com.ming.common.annotation.Log;
import com.ming.common.domain.LogDO;
import com.ming.common.service.LogService;
import com.ming.common.util.*;
import com.ming.system.domain.UserDO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Description: ${desc}
 * @Auther: jie_ming514@163.com
 * @Date: 2019/2/23 21:30
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.ming.common.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        saveLog(point, time);
        return result;
    }

    /**
     * 功能描述: 保存日志
     *
     * @param: point  切入点
     *         time   方法耗时
     * @return:
     * @auther: jie_ming514@163.com
     * @date: 2019/2/23 21:37
     */
    private void saveLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Log sysLog = method.getAnnotation(Log.class);
        LogDO logDO = new LogDO();
        if (sysLog != null) {
            //获取注解信息
            logDO.setOperation(sysLog.value());
        }
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        logDO.setMethod(className + "." + methodName + "()");

        Object[] args = point.getArgs();
        if(args != null && args.length > 0) {
            String params = StringUtils.limit(JSONUtils.beanToJson(args[0]), 1000);
            logDO.setParams(params);
        }
        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //获取IP地址
        logDO.setIp(IPUtils.getIpAddr(request));
        //获取用户名
        UserDO userDO = ShiroUtils.getUser();
        if(userDO == null) {
            if (logDO.getParams() == null) {
                logDO.setUserId(-1L);
                logDO.setUsername("用户信息为空");
            } else {
                logDO.setUserId(-1L);
                logDO.setUsername(logDO.getParams());
            }
        } else {
            logDO.setUserId(userDO.getUserId());
            logDO.setUsername(userDO.getUserName());
        }
        logDO.setTime((int) time);
        Date date = new Date();
        logDO.setGmtCreate(date);

        logService.save(logDO);
    }

}
