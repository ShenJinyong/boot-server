package com.javaboy.shiro.util;

import org.springframework.util.DigestUtils;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：加密工具类
 * @date ：2022/9/27 16:09
 */
public class EncryptUtil {

    public static String encrypt(String password) {
        return md5("noisivdoc__" + DigestUtils.md5DigestAsHex(password.getBytes()) + "__codvision");
    }

    public static String md5(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

}
