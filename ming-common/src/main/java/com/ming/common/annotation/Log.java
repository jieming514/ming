package com.ming.common.annotation;

import com.ming.common.enums.LogType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jie_ming514
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    //日志功能
    String value() default "";

    //日志类型
    LogType type() default LogType.SELECT;

}
