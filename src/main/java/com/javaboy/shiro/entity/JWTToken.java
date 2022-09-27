package com.javaboy.shiro.entity;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：JWTToken实现
 * @date ：2022/9/27 17:09
 */
@Data
public class JWTToken implements AuthenticationToken {

    private static final long serialVersionUID = 1282057025599826155L;

    private String token;

    private String exipreAt;

    public JWTToken(String token) {
        this.token = token;
    }

    public JWTToken(String token, String exipreAt) {
        this.token = token;
        this.exipreAt = exipreAt;
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