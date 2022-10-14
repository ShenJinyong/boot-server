package com.javaboy.common.enums;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：系统状态接口
 * @date ：2022/10/14 11:48
 */
public interface SystemStatus {
    // 获取系统状态码
    int getSystemStatusCode();
    // 获取系统状态信息
    String getSystemStatusMessage();

}
