package com.javaboy.core.enums;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：
 * @date ：2022/9/28 18:13
 */
public enum AppCode implements StatusCode{

    APP_SUCCESS(200, "业务正常"),
    INVALID_PARAM(4000,"参数校验异常"),
    MISTYPE_PARAM(4001,"参数格式异常"),
    MISSING_PARAM(4002,"缺少参数异常"),
    UNSUPPORTED_METHOD_TYPE(4003,"不支持请求类型"),
    UNSUPPORTED_METHOD(4004,"不支持请求"),
    SYS_UNKNOWN(4005,"系统异常"),
    APP_ERROR(400, "业务异常");

    private int code;
    private String message;

    AppCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
