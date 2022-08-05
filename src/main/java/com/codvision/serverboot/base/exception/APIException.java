package com.codvision.serverboot.base.exception;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： 定义API异常类
 * @date ：2022/8/5 10:52
 */
public class APIException extends RuntimeException{

    private int code;
    private String message;

    // 手动设置异常
    public APIException(int code, String message) {
        // message用于用户设置抛出错误详情，例如：当前价格-5，小于0
        super(message);
        // 状态码
        this.code = code;
        // 状态码配套的msg
        this.message = message;
    }

}
