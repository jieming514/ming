package com.ming.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 用于注解在方法中，被注解的方法可以将调用日志打印到数据库中
 * @Auther: jie_ming514@163.com
 * @Date: 2019/2/23 21:03
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
