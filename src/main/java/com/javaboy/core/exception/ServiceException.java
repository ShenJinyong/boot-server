package com.javaboy.core.exception;

import com.javaboy.core.enums.AppCode;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：
 * @date ：2022/9/28 18:37
 */
public class ServiceException extends RuntimeException{

    private static final long serialVersionUID = -7864604160297181941L;

    private int code;
    private String message;

    public ServiceException(int code,String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
