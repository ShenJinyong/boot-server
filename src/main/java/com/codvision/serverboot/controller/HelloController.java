package com.codvision.serverboot.controller;

import com.codvision.serverboot.dao.User;
import com.codvision.serverboot.mapper.UserMapper;
import com.codvision.serverboot.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HelloController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserServiceImpl userService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello,World!";
    }

    @PostMapping("/create")
    public String createUser(){
        User user = new User();
        user.setName("沈金勇");
        user.setSex("男");
        user.setPhone("18365418110");
        userService.save(user);
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        return "创建用户成功";
    }

}
