package com.javaboy.common.domain;

import com.javaboy.common.enums.AppCode;
import com.javaboy.common.exception.ServiceException;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：响应实体类
 * @date ：2022/10/14 13:49
 */
@Data
@ApiModel(description = "响应实体类")
public class ResponseEntity<T> {

    private static final long serialVersionUID = -1L;
    private boolean success;
    private T data;
    private int code;
    private String message;

    private ResponseEntity(boolean success, T data, AppCode appCode) {
        this.success = success;
        this.data = data;
        this.code = appCode.getSystemStatusCode();
        this.message = appCode.getSystemStatusMessage();
    }

    private ResponseEntity(boolean success, T data, int code, String message) {
        this.success = success;
        this.data = data;
        this.code = code;
        this.message = message;
    }

    /**
     * 成功返回-无数据
     */
    public static <T> ResponseEntity<T> ok() {
        return new ResponseEntity<>(Boolean.TRUE, null, AppCode.APP_SUCCESS);
    }

    /**
     * 成功返回-有数据
     */
    public static <T> ResponseEntity<T> ok(T data) {
        return new ResponseEntity<>(Boolean.TRUE, data, AppCode.APP_SUCCESS);
    }

    /**
     * 异常返回-指定错误码
     */
    public static ResponseEntity fail(AppCode appCode) {
        return new ResponseEntity(Boolean.FALSE, null, appCode);
    }

    /**
     * 自定义业务异常返回
     */
    public static ResponseEntity fail(ServiceException serviceException) {
        return new ResponseEntity(Boolean.FALSE, null, serviceException.getCode(),serviceException.getMessage());
    }

}

