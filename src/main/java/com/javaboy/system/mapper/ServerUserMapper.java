package com.javaboy.system.mapper;

import com.javaboy.system.entity.ServerUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-10-17 04:42:44
 */
@Mapper
public interface ServerUserMapper extends BaseMapper<ServerUser> {

    @Select("select password from server_user where username = #{username}")
    String findPassword(String username);

}
