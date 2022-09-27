package com.javaboy.shiro.mapper;

import com.javaboy.shiro.entity.ServerRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-09-27 03:02:23
 */
@Mapper
public interface ServerRoleMapper extends BaseMapper<ServerRole> {

    @Select("select id from server_role where user_id = #{userId}")
    public Set<String> selectRolePermissionByUserId(String userId);

}
