package com.javaboy.shiro.domain;

import com.javaboy.system.entity.ServerUser;
import com.javaboy.system.service.ServerUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：自定义用户域，Realm类似DataSource安全数据源
 * @date ：2022/10/14 14:57
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    private ServerUserService serverUserService;

    // 获取自定义域名称
    @Override
    public String getName() {
        return "UserRealm";
    }

    // 判断shiro支持的token类型
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        // 指定当前 authenticationToken 需要为 CustomToken 的实例
        return authenticationToken instanceof CustomToken;

    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行了授权=>AuthorizationInfo");
        // 获取SimpleAuthorizationInfo实例
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 获取当前的用户
        ServerUser currentUser = (ServerUser)principalCollection.getPrimaryPrincipal();
        // 获取用户角色集
        simpleAuthorizationInfo.addRole("admin");
        // 获取用户权限集
        simpleAuthorizationInfo.addStringPermission("user:add");
        return simpleAuthorizationInfo;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("执行了认证=>AuthenticationInfo");
        String username = null;
        try{
            if(authenticationToken instanceof CustomToken){
                // 自定义客户端登录类型处理
                CustomToken customToken = (CustomToken) authenticationToken;
                username = customToken.getUsername();
            }
        } catch (Exception e){
            throw new AuthenticationException();
        }
        // 查询用户
        ServerUser serverUser = serverUserService.queryServerUserByUserName(username);
        // 密码认证，shiro做~
        String password = serverUser.getPassword();
        // 使用SimpleAuthenticationInfo实例认证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(serverUser, password, getName());
        // 获取当前用户
        Subject currentSubject = SecurityUtils.getSubject();
        // 获取当前会话session
        Session session = currentSubject.getSession();
        // 设置会话session
        session.setAttribute("user",serverUser);
        return simpleAuthenticationInfo;

    }

}
