package com.javaboy.common.exception;

import com.javaboy.common.enums.AppCode;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：服务异常
 * @date ：2022/10/14 11:47
 */
public class ServiceException extends RuntimeException{

    private static final long serialVersionUID = -7864604160297181941L;
    private int code;
    private String message;

    public ServiceException(AppCode appCode) {
        this.code = appCode.getSystemStatusCode();
        this.message = appCode.getSystemStatusMessage();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

