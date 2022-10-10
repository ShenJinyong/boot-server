package com.javaboy.shiro.util;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：
 * @date ：2022/10/9 16:12
 */
public class ShiroToken implements AuthenticationToken {

    private final String token;

    public ShiroToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
