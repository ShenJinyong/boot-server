package com.codvision.serverboot.base.annotation;

import com.codvision.serverboot.base.enums.LogType;

import java.lang.annotation.*;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： 日志类别的枚举类
 * @date ：2022/8/5 14:00
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LessLog {

    LogType type() default LogType.NONE;
}
