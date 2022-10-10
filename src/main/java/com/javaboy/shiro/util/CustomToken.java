package com.javaboy.shiro.util;

import com.javaboy.shiro.enums.LoginType;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：客户端Token
 * @date ：2022/10/9 15:09
 */
public class CustomToken extends UsernamePasswordToken {

    private static final long serialVersionUID = -2564928913725078138L;

    private LoginType loginType;

    public CustomToken() {
        super();
    }

    public CustomToken(String username) {
        super(username, "", false, null);
        this.loginType = LoginType.NO_PASSWORD;
    }

    public CustomToken(String username, String password) {
        super(username, EncryptUtil.encrypt(password));
        this.loginType = LoginType.PASSWORD;
    }

    public CustomToken(String username, String password, LoginType type, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
        this.loginType = type;
    }

    public void setType(LoginType loginType) {
        this.loginType= loginType;
    }

    public LoginType getLoginType() {
        return loginType;
    }
}
