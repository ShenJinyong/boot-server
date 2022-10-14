package com.javaboy.common.advice;

import com.javaboy.common.domain.ResponseEntity;
import com.javaboy.common.enums.AppCode;
import com.javaboy.common.exception.ServiceException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：
 * @date ：2022/10/14 13:55
 */
@Slf4j
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Resource
    HttpServletRequest httpServletRequest;

    @Override
    public boolean supports(@NonNull MethodParameter methodParameter,@NonNull Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  @NonNull MethodParameter returnType,
                                  @NonNull MediaType selectedContentType,
                                  @NonNull Class selectedConverterType,
                                  ServerHttpRequest request,
                                  @NonNull ServerHttpResponse response) {

        // 拦截swagger相关请求
        if(request.getURI().getPath().contains("swagger-ui") || request.getURI().getPath().contains("api-docs")){
            return body;
        }
        // 返回对象封装
        if (body instanceof ResponseEntity) {
            // 被exceptionHandler处理过了，直接返回
            return body;
        }else if (body instanceof String){
            // 处理String类型，否则会出现类型转换错误String=>ResponseEntity，直接返回
            return body;
        }else {
            return ResponseEntity.ok(body);
        }

    }

    /**
     * 异常日志记录
     */
    private void logErrorRequest(Exception e) {
        log.error("报错API URL:{}", httpServletRequest.getRequestURL().toString());
        log.error("异常:{}", e.getMessage());
    }

    /**
     * 参数未通过@Valid验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    private ResponseEntity methodArgumentNotValid(MethodArgumentNotValidException exception) {
        logErrorRequest(exception);
        return ResponseEntity.fail(AppCode.INVALID_PARAM);
    }

    /**
     * 参数格式有误
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
    @ResponseBody
    private ResponseEntity typeMismatch(Exception exception) {
        logErrorRequest(exception);
        return ResponseEntity.fail(AppCode.MISTYPE_PARAM);
    }

    /**
     * 缺少参数
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    private ResponseEntity missingServletRequestParameter(MissingServletRequestParameterException exception) {
        logErrorRequest(exception);
        return ResponseEntity.fail(AppCode.MISSING_PARAM);
    }

    /**
     * 不支持的请求类型
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    private ResponseEntity httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception) {
        logErrorRequest(exception);
        return ResponseEntity.fail(AppCode.UN_SUPPORTED_METHOD_TYPE);
    }

    /**
     * 不支持的请求
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    private ResponseEntity noHandlerFoundException(NoHandlerFoundException exception) {
        logErrorRequest(exception);
        return ResponseEntity.fail(AppCode.UN_SUPPORTED_METHOD);
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    private ResponseEntity serviceExceptionHandler(ServiceException serviceException) {
        logErrorRequest(serviceException);
        return ResponseEntity.fail(serviceException);
    }

    /**
     * 其他异常
     */
    @ExceptionHandler({HttpClientErrorException.class, IOException.class, Exception.class})
    @ResponseBody
    private ResponseEntity commonExceptionHandler(Exception exception) {
        logErrorRequest(exception);
        return ResponseEntity.fail(AppCode.SYS_UNKNOWN);
    }

}
