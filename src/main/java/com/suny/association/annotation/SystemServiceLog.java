package com.suny.association.annotation;

import java.lang.annotation.*;

/**
 * Comments:   业务逻辑层日志注解
 * Author:   孙建荣
 * Create Date: 2017/04/24 22:39
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {

    String description() default "";
}
