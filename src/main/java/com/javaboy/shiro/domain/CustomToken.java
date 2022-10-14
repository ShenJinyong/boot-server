package com.javaboy.shiro.domain;

import com.javaboy.shiro.enums.LoginType;
import com.javaboy.system.util.EncryptUtil;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：客户端登录
 * @date ：2022/10/14 14:40
 */
public class CustomToken extends UsernamePasswordToken {

    private static final long serialVersionUID = -2564928913725078138L;

    private LoginType loginType;

    public CustomToken(String username) {
        super(username, "", false, null);
        this.loginType = LoginType.NO_PASSWORD;
    }

    public CustomToken(String username, String password) {
        super(username, EncryptUtil.encrypt(password));
        this.loginType = LoginType.PASSWORD;
    }

    public LoginType getLoginType() {
        return loginType;
    }

}
