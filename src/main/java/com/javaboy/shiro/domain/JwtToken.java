package com.javaboy.shiro.domain;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description Jwt Token代替原生的UsernamePasswordToken
 * @date ：2022/10/15 14:37
 */
public class JwtToken implements AuthenticationToken {

    private final String token;

    public JwtToken(String token) {
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
