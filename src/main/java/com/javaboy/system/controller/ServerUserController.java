package com.javaboy.system.controller;


import com.javaboy.common.domain.ResponseEntity;
import com.javaboy.common.enums.AppCode;
import com.javaboy.shiro.domain.CustomToken;
import com.javaboy.system.entity.ServerUser;
import com.javaboy.system.util.EncryptUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 沈金勇 438217638@qq.com
 * @since 2022-10-14 11:43:29
 */
@RestController
@RequestMapping("/system/serverUser")
public class ServerUserController {

    @PostMapping("/register")
    public String register(@RequestParam(value = "username")String username,
                           @RequestParam(value = "password")String password) {
        ServerUser serverUser = new ServerUser();
        serverUser.setUsername(username);
        serverUser.setPassword(EncryptUtil.encrypt(password));
        return "注册用户成功";
    }

    @GetMapping("/login")
    public ResponseEntity<ServerUser> login(@RequestParam(value = "username")String username,
                                            @RequestParam(value = "password")String password){
        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        CustomToken customToken = new CustomToken(username, password);
        try {
            // 执行登录方法，如果没有异常就说明OK
            subject.login(customToken);
        } catch (AuthenticationException e){
            customToken.clear();
            /**
             * 身份验证失败类型
             * AuthenticationException
             *  子类：
             *  DisabledAccountException（禁用的帐号）
             *  LockedAccountException（锁定的帐号）
             *  UnknownAccountException（错误的帐号）
             *  ExcessiveAttemptsException（登录失败次数过多）
             *  IncorrectCredentialsException （错误的凭证）
             *  ExpiredCredentialsException（过期的凭证）
             * */
            return ResponseEntity.fail(AppCode.USERNAME_OR_PASSWORD_ERROR);
        }
        // 获取返回结果
        ServerUser serverUser = (ServerUser) subject.getSession().getAttribute("user");
        return ResponseEntity.ok(serverUser);
    }

    @GetMapping("/loginSignature")
    @ApiOperation("免密登录")
    public ResponseEntity<ServerUser> loginSignature(@RequestParam(value = "username")String username) {
        Subject subject = SecurityUtils.getSubject();
        CustomToken customToken = new CustomToken(username);
        try {
            // 执行登录方法，如果没有异常就说明OK
            subject.login(customToken);
        } catch (AuthenticationException e){
            customToken.clear();
            // 用户名或密码错误
            return ResponseEntity.fail(AppCode.USERNAME_OR_PASSWORD_ERROR);
        }
        // 获取返回结果
        ServerUser serverUser = (ServerUser) subject.getSession().getAttribute("user");
        return ResponseEntity.ok(serverUser);
    }


    @GetMapping("/queryOne")
    @ApiOperation("查询用户")
    public String queryOne() {
        return "查询用户";
    }

    @GetMapping("/queryAll")
    @ApiOperation("查询所有用户")
    public String queryAll() {
        return "查询所有用户";
    }

}

