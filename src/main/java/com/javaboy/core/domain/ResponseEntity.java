package com.javaboy.core.domain;

import com.javaboy.core.enums.AppCode;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：返回响应实体类
 * @date ：2022/9/28 18:09
 */
@Data
@ApiModel(description = "返回响应实体类")
public class ResponseEntity<T> {

    private static final long serialVersionUID = -1L;
    private boolean success;
    private T data;
    private int code;
    private String message;

    private ResponseEntity(boolean success, T data, int code, String message) {
        this.success = success;
        this.data = data;
        this.code = code;
        this.message = message;
    }

    private ResponseEntity(boolean success, T data, AppCode appCode) {
        this.success = success;
        this.data = data;
        this.code = appCode.getCode();
        this.message = appCode.getMessage();
    }

    /**
     * 成功返回
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
     * 异常返回-非指定异常
     */
    public static ResponseEntity fail(int code, String message) {
        return new ResponseEntity(Boolean.FALSE, null, code, message);
    }


}
