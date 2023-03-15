package com.example.common.annotation;

import com.example.common.enums.LogTypeEnum;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LessLog {

    LogTypeEnum type() default LogTypeEnum.NONE;
}