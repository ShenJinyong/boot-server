package com.javaboy.shiro.domain;

import com.javaboy.shiro.enums.LoginType;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：Shiro编码加密
 * @date ：2022/10/14 15:08
 */
public class MyRetryLimitCredentialsMatcher extends SimpleCredentialsMatcher {

    // 匹配用户输入的token的凭证（未加密）与系统提供的凭证（已加密）
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        // 处理客户端Token
        if (authcToken instanceof CustomToken) {
            CustomToken customToken = (CustomToken) authcToken;
            // 处理免密登录,放行
            if (customToken.getLoginType().equals(LoginType.NO_PASSWORD)) {
                return true;
            }
        }
        return super.doCredentialsMatch(authcToken, info);
    }
}
