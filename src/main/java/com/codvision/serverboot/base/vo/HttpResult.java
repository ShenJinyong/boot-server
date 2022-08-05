package com.codvision.serverboot.base.vo;

import com.codvision.serverboot.base.enums.ResultInfoEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： 封装统一的返回结果
 * @date ：2022/8/5 9:42
 */
@Data
@Accessors(chain = true)
@Builder
@ApiModel("返回结果")
public class HttpResult<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    @ApiModelProperty("标识")
    private boolean success;

    @ApiModelProperty("状态码")
    private int code;

    @ApiModelProperty("消息描述")
    private String message;

    @ApiModelProperty("返回数据")
    private T data;

    /**
     * 无返回数据
     * */
    public static HttpResult ok(ResultInfoEnum resultInfoEnum){
        return HttpResult.builder()
                .success(resultInfoEnum.getSuccess())
                .code(resultInfoEnum.getCode())
                .message(resultInfoEnum.getMessage())
                .build();
    }

    /**
     * 有返回数据
     * */
    public static <T> HttpResult<T> ok(ResultInfoEnum resultInfoEnum,T data){
        return HttpResult.<T>builder()
                .success(resultInfoEnum.getSuccess())
                .code(resultInfoEnum.getCode())
                .message(resultInfoEnum.getMessage())
                .data(data)
                .build();
    }

}
