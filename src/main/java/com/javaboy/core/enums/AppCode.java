package com.javaboy.core.enums;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：系统枚举
 * @date ：2022/9/28 18:13
 */
public enum AppCode implements StatusCode{

    APP_SUCCESS(200, "业务正常"),
    INVALID_PARAM(4000,"参数校验异常"),
    MISTYPE_PARAM(4001,"参数格式异常"),
    MISSING_PARAM(4002,"缺少参数异常"),
    UN_SUPPORTED_METHOD_TYPE(4003,"不支持请求类型"),
    UN_SUPPORTED_METHOD(4004,"不支持请求"),
    SYS_UNKNOWN(4005,"系统异常"),
    UN_LOGIN(4006,"未登录"),
    UN_AUTHORIZED(4007,"未授权"),
    USERNAME_OR_PASSWORD_ERROR(4008,"用户名或者密码错误"),
    NO_PASSWORD_TIMESTAMP_ERROR(4009,"免密时间戳错误"),
    NO_PASSWORD_SIGNATURE_ERROR(4009,"免密签名错误"),
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
