package com.kj.permission.annotation;

import java.lang.annotation.*;

/**
 * @author 破晓
 * @date 2022-01-23 22:28
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Permission
public @interface GeneralAdmin {
    int role() default 0;
}
