package com.javaboy.shiro.service.impl;

import com.javaboy.shiro.entity.JWTToken;
import com.javaboy.shiro.entity.ServerUser;
import com.javaboy.shiro.service.ServerAuthService;
import com.javaboy.shiro.service.ServerRoleService;
import com.javaboy.shiro.service.ServerUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：自定义的UserRealm
 * @date ：2022/9/27 10:29
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    private ServerUserService serverUserService;

    @Resource
    private ServerRoleService serverRoleService;

    @Resource
    private ServerAuthService serverAuthService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行了授权=>AuthorizationInfo");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        ServerUser currentUser = (ServerUser)subject.getPrincipal();
        // 获取用户角色集
//        Set<String> serverRoles = serverRoleService.selectRolePermissionByUserId(currentUser.getId());
//        simpleAuthorizationInfo.addRoles(serverRoles);
        // 获取用户权限集
//        Set<String> serverAuths = serverAuthService.findUserPermissionsByUserId(currentUser.getId());
//        simpleAuthorizationInfo.addStringPermissions(serverAuths);
//        simpleAuthorizationInfo.addStringPermission("user:add");
        return simpleAuthorizationInfo;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("执行了认证=>AuthenticationInfo");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        List<ServerUser> serverUserList = serverUserService.queryServerUserByUserName(token.getUsername());
        if(serverUserList.size() == 1){
            // 密码认证，shiro做~
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(serverUserList.get(0), serverUserList.get(0).getPassword(), "");
            // 存储session
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            session.setAttribute("loginUser",serverUserList.get(0));
            return simpleAuthenticationInfo;
        }else if(serverUserList.size() == 0){
            // 抛出异常 UnKnownAccountException
            return null;
        }else{
            // 抛出异常 RepeatKnownAccountException
            return null;
        }

    }

}
