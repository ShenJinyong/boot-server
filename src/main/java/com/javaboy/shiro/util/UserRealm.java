package com.javaboy.shiro.util;

import com.javaboy.core.exception.ServiceException;
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
import org.springframework.context.annotation.Bean;

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

    // 获取自定义域名称
    @Override
    public String getName() {
        return "UserRealm";
    }

    // 判断shiro支持的token类型
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        // 指定当前 authenticationToken 需要为 ShiroAuthToken 的实例
        return authenticationToken instanceof CustomToken || authenticationToken instanceof ShiroToken;

    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行了授权=>AuthorizationInfo");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        ServerUser currentUser = (ServerUser)principalCollection.getPrimaryPrincipal();
        // 获取用户角色集
//        Set<String> serverRoles = serverRoleService.selectRolePermissionByUserId(currentUser.getId());
//        simpleAuthorizationInfo.addRoles(serverRoles);
        simpleAuthorizationInfo.addRole("admin");
        // 获取用户权限集
//        Set<String> serverAuths = serverAuthService.findUserPermissionsByUserId(currentUser.getId());
//        simpleAuthorizationInfo.addStringPermissions(serverAuths);
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
        List<ServerUser> serverUserList = serverUserService.queryServerUserByUserName(username);
        if(serverUserList.size() == 1){
            // 密码认证，shiro做~
            String password = serverUserList.get(0).getPassword();
            ServerUser serverUser = serverUserList.get(0);
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(serverUser, password, getName());
            // 存储session
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            session.setAttribute("user",serverUser);
            return simpleAuthenticationInfo;
        }else if(serverUserList.size() == 0){
            // 抛出异常 UnKnownAccountException
            throw new ServiceException(10000,"UnKnownAccountException");
        }else{
            // 抛出异常 RepeatKnownAccountException
            throw new ServiceException(10001,"RepeatKnownAccountException");
        }

    }

}
