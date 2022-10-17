package com.javaboy.common.enums;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：应用码枚举类
 * @date ：2022/10/14 11:51
 */
public enum AppCode implements SystemStatus{

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
    UN_KNOWN_ACCOUNT_EXCEPTION(4010,"用户名不存在异常"),
    REPEAT_KNOWN_ACCOUNT_EXCEPTION(4011,"用户名不唯一"),
    USERNAME_IS_EXISTS(4012,"用户名已存在"),
    INSERT_USER_EXCEPTION(4013,"创建用户异常"),
    NOT_FOUND_USER_BY_ID(4014,"根本id找不到用户"),
    NEW_PASSWORD_SAME_AS_OLD_PASSWORD(4015,"新密码与旧密码相同"),
    CHANGE_PASSWORD_EXCEPTION(4015,"修改密码失败"),
    APP_ERROR(400, "业务异常");

    private int code;
    private String message;

    AppCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    @Override
    public int getSystemStatusCode() {
        return code;
    }

    @Override
    public String getSystemStatusMessage() {
        return message;
    }

}
