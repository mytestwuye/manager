package com.suny.association.annotation;

import java.lang.annotation.*;

/**
 * Comments:   controller层日志记录类
 * Author:   孙建荣
 * Create Date: 2017/04/24 22:33
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {

    String description() default "";

}
