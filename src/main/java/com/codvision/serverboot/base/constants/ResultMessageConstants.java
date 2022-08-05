package com.codvision.serverboot.base.constants;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： 定义返回信息常量
 * @date ：2022/8/5 9:32
 */
public class ResultMessageConstants {

    public static final String SUCCESS = "操作成功";
    public static final String NO_HANDLER_FOUND_EXCEPTION = "没有发现处理程序异常";
    public static final String UN_SUPPORTED_METHOD_EXCEPTION = "请求的类型不支持";
    public static final String MISSING_SERVLET_REQUEST_PARAMETER = "缺少请求参数";
    public static final String PARAMETER_FORMAT_EXCEPTION = "请求参数格式有误";
    public static final String INVALID_PARAMETER = "参数未通过@Valid验证异常";
    public static final String SYS_UNKNOWN = "参数未通过@Valid验证异常";
    public static final String SERVICE_EXCEPTION = "业务层异常";

}
