package com.javaboy.system.service.impl;

import com.javaboy.system.entity.ServerRole;
import com.javaboy.system.mapper.ServerRoleMapper;
import com.javaboy.system.service.ServerRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-10-17 04:42:44
 */
@Service
public class ServerRoleServiceImpl extends ServiceImpl<ServerRoleMapper, ServerRole> implements ServerRoleService {

    @Override
    public ServerRole createRole(ServerRole role) {
        return null;
    }

    @Override
    public void deleteRole(Long roleId) {

    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {

    }

    @Override
    public void unCorrelationPermissions(Long roleId, Long... permissionIds) {

    }
}
