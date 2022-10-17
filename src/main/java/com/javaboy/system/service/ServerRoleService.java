package com.javaboy.system.service;

import com.javaboy.system.entity.ServerRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-10-17 04:42:44
 */
public interface ServerRoleService extends IService<ServerRole> {

    // 创建角色
    ServerRole createRole(ServerRole role);
    // 删除角色
    void deleteRole(Long roleId);
    // 添加角色-权限之间关系
    void correlationPermissions(Long roleId, Long... permissionIds);
    // 移除角色-权限之间关系
    void unCorrelationPermissions(Long roleId, Long... permissionIds);
}
