package com.kj.permission.annotation;

import java.lang.annotation.*;

/**
 * @author 破晓
 * @date 2022-01-24 0:30
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {

    int role() default 0;
}
