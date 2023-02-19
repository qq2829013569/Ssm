package com.cloud.aop;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LimiteRequest {
    long time() default 6000;
    int count() default 3;
}
