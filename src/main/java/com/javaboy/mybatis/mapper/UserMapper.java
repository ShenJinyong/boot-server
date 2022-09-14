package com.javaboy.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaboy.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：MyBatis测试用户
 * @date ：2022/9/14 14:13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
