package com.javaboy.mybatis;

import com.javaboy.mybatis.entity.User;
import com.javaboy.mybatis.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： MyBatisPlus测试类
 * @date ：2022/9/14 14:14
 */
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        System.out.println(("----- selectInsert method test ------"));
        User user = new User();
        user.setName("沈金勇");
        user.setAge(24);
        user.setEmail("438217638@qq.com");
        userMapper.insert(user);
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

}
