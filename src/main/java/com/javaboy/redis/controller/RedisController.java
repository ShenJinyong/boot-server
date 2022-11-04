package com.javaboy.redis.controller;

import com.javaboy.common.domain.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：Redis模块
 * @date ：2022/11/4 21:36
 */
@Tag(name = "Redis管理")
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Operation(summary = "Redis测试")
    @GetMapping("/set")
    public ResponseEntity redis(){
        redisTemplate.opsForValue().set("name","沈金勇");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name："+name);
        return ResponseEntity.ok();
    }

}
