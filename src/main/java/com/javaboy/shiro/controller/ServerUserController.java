package com.javaboy.shiro.controller;


import com.javaboy.shiro.entity.ServerUser;
import com.javaboy.shiro.service.ServerUserService;
import com.javaboy.shiro.util.EncryptUtil;
import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public String login(String username,String password){
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, EncryptUtil.encrypt(password));
        try {
            // 获取当前的用户
            Subject subject = SecurityUtils.getSubject();
            // 执行登录方法，如果没有异常就说明OK
            subject.login(token);
            return "用户登录";
        } catch (UnknownAccountException e){
            // 用户名不存在
            return "用户名错误";
        }  catch (IncorrectCredentialsException e){
            // 密码不存在
            return "密码错误";
        }
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

