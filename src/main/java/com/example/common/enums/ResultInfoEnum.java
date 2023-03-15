package com.example.common.enums;

import com.example.common.constant.ResultMessageConstant;
import com.example.common.service.ResultInfoService;

public enum ResultInfoEnum  implements ResultInfoService {

    SUCCESS(Boolean.TRUE,"200", ResultMessageConstant.SUCCESS),
    // 异常处理
    NO_HANDLER_FOUND_EXCEPTION(Boolean.FALSE,"404",ResultMessageConstant.NO_HANDLER_FOUND_EXCEPTION),
    UN_SUPPORTED_METHOD_EXCEPTION(Boolean.FALSE,"405",ResultMessageConstant.UN_SUPPORTED_METHOD_EXCEPTION),
    MISSING_SERVLET_REQUEST_PARAMETER(Boolean.FALSE,"400",ResultMessageConstant.MISSING_SERVLET_REQUEST_PARAMETER),
    PARAMETER_FORMAT_EXCEPTION(Boolean.FALSE,"401",ResultMessageConstant.PARAMETER_FORMAT_EXCEPTION),
    INVALID_PARAMETER(Boolean.FALSE,"402",ResultMessageConstant.INVALID_PARAMETER),
    SERVICE_EXCEPTION(Boolean.FALSE,"403",ResultMessageConstant.SERVICE_EXCEPTION),
    SYS_UNKNOWN(Boolean.FALSE,"500",ResultMessageConstant.SYS_UNKNOWN)
    ;

    private boolean success;
    private String code;
    private String message;

    ResultInfoEnum(Boolean success,String code,String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
