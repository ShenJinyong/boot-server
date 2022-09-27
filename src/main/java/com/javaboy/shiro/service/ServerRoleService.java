package com.javaboy.shiro.service;

import com.javaboy.shiro.entity.ServerRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-09-27 03:02:23
 */
public interface ServerRoleService extends IService<ServerRole> {

    Set<String> selectRolePermissionByUserId(String userId);

}
