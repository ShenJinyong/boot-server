package com.javaboy.shiro.controller;


import com.javaboy.core.domain.ResponseEntity;
import com.javaboy.core.enums.AppCode;
import com.javaboy.shiro.entity.ServerUser;
import com.javaboy.shiro.service.ServerUserService;
import com.javaboy.shiro.util.CustomToken;
import com.javaboy.shiro.util.EncryptUtil;
import com.javaboy.shiro.util.Md5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-09-27 03:02:23
 */
@RestController
@RequestMapping("/shiro/serverUser")
public class ServerUserController {

    @Resource
    private ServerUserService serverUserService;

    @PostMapping("/register")
    public String register(String username,String password) {
        ServerUser serverUser = new ServerUser();
        serverUser.setUsername(username);
        serverUser.setPassword(EncryptUtil.encrypt(password));
        serverUserService.save(serverUser);
        return "注册用户";
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
            // 用户名或密码错误
            return ResponseEntity.fail(AppCode.USERNAME_OR_PASSWORD_ERROR);
        }
        // 获取返回结果
        ServerUser serverUser = (ServerUser) subject.getSession().getAttribute("user");
        return ResponseEntity.ok(serverUser);
    }

    @GetMapping("/loginSignature")
    public ResponseEntity<ServerUser> loginSignature(@RequestParam(value = "username") String username,
                                 @RequestParam(value = "signature") String signature,
                                 @RequestParam(value = "ts") Long ts){
        // 验证时间戳
        if (Math.abs(ts - System.currentTimeMillis()) > 10 * 60 * 1000) {
            return ResponseEntity.fail(AppCode.NO_PASSWORD_TIMESTAMP_ERROR);
        }
        // 验证签名
        String md5 = Md5Util.getMd5(username + ts + "codvision");
        if (!md5.equals(signature)) {
            return ResponseEntity.fail(AppCode.NO_PASSWORD_SIGNATURE_ERROR);
        }
        // 登录
        Subject subject = SecurityUtils.getSubject();
        CustomToken customToken = new CustomToken(username);
        try {
            subject.login(customToken);
        } catch (AuthenticationException e) {
            customToken.clear();
            // 用户名或密码错误
            return ResponseEntity.fail(AppCode.USERNAME_OR_PASSWORD_ERROR);
        }
        // 获取返回结果
        ServerUser serverUser = (ServerUser) subject.getSession().getAttribute("user");
        return ResponseEntity.ok(serverUser);
    }

    @GetMapping("/loginOut")
    public String loginOut(){
        return "退出用户";
    }

    @DeleteMapping("/delete")
    public String delete(){
        return "删除用户";
    }

    @PostMapping("/update")
    public String update(){
        return "修改用户";
    }

    @GetMapping("/queryOne")
    public String queryOne(){
        return "查询用户";
    }

    @GetMapping("/queryAll")
    public String queryAll(){
        return "查询所有用户";
    }

}

