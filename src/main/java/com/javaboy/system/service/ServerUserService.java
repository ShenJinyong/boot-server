package com.javaboy.system.service;

import com.javaboy.system.entity.ServerUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-10-17 04:42:44
 */
public interface ServerUserService extends IService<ServerUser> {
    // 创建账户
    int createUser(ServerUser user);
    // 添加用户-角色关系
    void correlationRoles(Long userId, Long... roleIds);
    // 移除用户-角色关系
    void unCorrelationRoles(Long userId, Long... roleIds);
    // 根据用户名查找用户
    ServerUser findByUsername(String username);
    // 根据用户名查找其角色
    Set<String> findRoles(String username);
    // 根据用户名查找其权限
    Set<String> findPermissions(String username);


}
