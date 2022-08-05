package com.codvision.serverboot.base.service;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： 定义获取结果信息的服务
 * @date ：2022/8/5 9:20
 */
public interface ResultInfoService {

    /***
     * 获取返回的结果标识
     * */
    Boolean getSuccess();
    /**
     * 获取返回结果的编码
     * */
    int getCode();
    /**
     * 获取返回结果的信息
     * */
    String getMessage();

}
