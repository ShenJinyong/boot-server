package com.javaboy.shiro.enums;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：登录类型枚举类
 * @date ：2022/10/8 18:52
 */
public enum LoginType {

    PASSWORD("password"),
    NO_PASSWORD("no_password");

    private final String code;

    LoginType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
