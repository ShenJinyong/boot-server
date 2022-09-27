package com.javaboy.shiro.mapper;

import com.javaboy.shiro.entity.ServerUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-09-27 03:02:23
 */
@Mapper
public interface ServerUserMapper extends BaseMapper<ServerUser> {

    @Select("select * from server_user where username = #{username}")
    List<ServerUser> queryServerUserByUserName(String username);

}
