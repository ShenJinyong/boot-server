package com.javaboy.shiro.mapper;

import com.javaboy.shiro.entity.ServerAuth;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-09-27 03:02:23
 */
@Mapper
public interface ServerAuthMapper extends BaseMapper<ServerAuth> {

    @Select("select id from server_auth where user_id = #{userId}")
    Set<String> findUserPermissionsByUserId(String userId);

}
