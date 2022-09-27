package com.javaboy.shiro.controller;

import com.javaboy.shiro.entity.ServerUser;
import com.javaboy.shiro.service.ServerUserService;
import com.javaboy.shiro.util.EncryptUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：
 * @date ：2022/9/27 11:25
 */
@RestController
public class LoginController {

    @RequestMapping({"/","/index"})
    public String toIndex(){
        return "首页";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "添加用户";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "修改页面";
    }

    @RequestMapping("/redirectLogin")
    public String RedirectLogin(){
        return "重定向登录页面";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "登录页面";
    }

    @RequestMapping("/noAuth")
    public String noAuth(){
        return "未授权页面";
    }

    @RequestMapping("/login")
    public String login(String username,String password){
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, EncryptUtil.encrypt(password));
        try {
            // 获取当前的用户
            Subject subject = SecurityUtils.getSubject();
            // 执行登录方法，如果没有异常就说明OK
            subject.login(token);
            return "首页";
        } catch (UnknownAccountException e){
            // 用户名不存在
            return "用户名错误";
        }  catch (IncorrectCredentialsException e){
            // 密码不存在
            return "密码错误";
        }
    }

    @Resource
    private ServerUserService serverUserService;

    @RequestMapping("/register")
    public String register(String username,String password) {
        ServerUser serverUser = new ServerUser();
        serverUser.setUsername(username);
        serverUser.setPassword(EncryptUtil.encrypt(password));
        serverUserService.save(serverUser);
        return "注册用户成功";
    }

}
