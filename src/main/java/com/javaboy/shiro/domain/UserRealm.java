package com.javaboy.shiro.domain;

import com.javaboy.shiro.enums.LoginType;
import com.javaboy.shiro.util.JwtUtil;
import com.javaboy.system.entity.ServerUser;
import com.javaboy.system.service.ServerUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：自定义用户域，Realm类似DataSource安全数据源
 * @date ：2022/10/14 14:57
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    private ServerUserService serverUserService;

    // 返回一个唯一的Realm名字
    @Override
    public String getName() {
        return "UserRealm";
    }

    // 判断此Realm是否支持此Token
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        // 指定当前 authenticationToken 需要为 CustomToken 的实例 或者 JwtToken 的实例
        return authenticationToken instanceof CustomToken || authenticationToken instanceof JwtToken;
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
        Set<String> roles = serverUserService.findRoles(currentUser.getUsername());
        // 设置用户角色集
        simpleAuthorizationInfo.addRoles(roles);
        // 获取用户权限集
        Set<String> permissions = serverUserService.findPermissions(currentUser.getUsername());
        // 设置用户权限集
        simpleAuthorizationInfo.addStringPermissions(permissions);
        // 如果身份认证授权成功，返回一个AuthenticationInfo实现
        return simpleAuthorizationInfo;
    }

    // 根据Token获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("执行了认证=>AuthenticationInfo");
        String token = "";
        String username = "";
        // 自定义客户端登录类型处理
        if(authenticationToken instanceof CustomToken){
            CustomToken customToken = (CustomToken) authenticationToken;
            log.info("CustomToken:"+customToken);
            username = customToken.getUsername();
            log.info("username:"+username);
            if(customToken.getLoginType().equals(LoginType.PASSWORD)){
                // 账号密码登录处理
                String password = String.valueOf(customToken.getPassword());
                token = JwtUtil.sign(username,password);
            }else {
                // 免密登录处理
                token = JwtUtil.sign(username);
            }
            log.info("token:"+token);
        }else if(authenticationToken instanceof JwtToken){
            // Jwt Token登录类型处理
            token = (String) authenticationToken.getPrincipal();
            username = JwtUtil.getUsername(token);
        }else {
            // 未知登录类型处理
            throw new UnsupportedTokenException();
        }

        // 查询用户
        ServerUser serverUser = serverUserService.findByUsername(username);
        if(serverUser == null){
            // 没找到帐号
            throw new UnknownAccountException();
        }else{
            if(serverUser.getDeleted() == 1 || serverUser.getLocked() == 1){
                // 账号被删除或者锁定
                throw new LockedAccountException();
            }
        }
        // 密码认证，shiro做~
        String password = serverUser.getPassword();
        // 使用SimpleAuthenticationInfo实例认证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(token, password, getName());
        // 如果身份认证验证成功，返回一个AuthenticationInfo实现
        return simpleAuthenticationInfo;
    }

}
