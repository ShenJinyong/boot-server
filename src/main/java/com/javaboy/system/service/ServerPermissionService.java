package com.javaboy.system.service;

import com.javaboy.system.entity.ServerPermission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-10-17 04:42:44
 */
public interface ServerPermissionService extends IService<ServerPermission> {

    // 创建权限
    ServerPermission createPermission(ServerPermission permission);
    // 删除权限
    public void deletePermission(Long permissionId);

}
