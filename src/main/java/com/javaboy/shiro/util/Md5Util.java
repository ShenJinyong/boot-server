package com.javaboy.shiro.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：Md5加密工具类
 * @date ：2022/10/10 9:45
 */
public class Md5Util {

    public static String getMd5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            String md5 = new BigInteger(1, md.digest()).toString(16);
            return md5;
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误:" + e.getMessage(), e);
        }
    }

}
