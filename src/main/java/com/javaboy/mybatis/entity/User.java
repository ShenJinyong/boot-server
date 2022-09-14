package com.javaboy.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：测试使用User
 * @date ：2022/9/14 14:08
 */
@Data
@TableName("test_user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
