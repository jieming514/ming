package com.ming.common.aspect;

import com.ming.common.util.ShiroUtils;
import com.ming.common.util.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 请求日志统一处理
 * @author jie_ming514@163.com
 * @version 1.0
 */
@Aspect
@Component
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);


    @Pointcut("execution(* com.ming.*.controller.*.*(..))")
    public void logPointCut() {
    }


    /**
     *
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: jie_ming514@163.com
     * @date: 2018/10/5 1:23
     */
    @Before("logPointCut()")
    public void doBefore(JoinPoint point) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //1. 请求内容
        logger.info(request.getMethod() + ":" + request.getRequestURL().toString());
        // 获取真实的ip地址
        logger.info("CLASS_METHOD: " + point.getSignature().getDeclaringTypeName() + "."
                + point.getSignature().getName());
        logger.info("args:" + Arrays.toString(point.getArgs()));
        logger.info("USER:" + ShiroUtils.getUserName());

    }

    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void doAfterReturning(Object result) {
        logger.debug("RESULT:" + StringUtils.limit(result.toString()));
    }

}
