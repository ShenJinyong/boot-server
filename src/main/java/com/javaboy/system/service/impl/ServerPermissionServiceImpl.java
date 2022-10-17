package com.javaboy.system.service.impl;

import com.javaboy.system.entity.ServerPermission;
import com.javaboy.system.mapper.ServerPermissionMapper;
import com.javaboy.system.service.ServerPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-10-17 04:42:44
 */
@Service
public class ServerPermissionServiceImpl extends ServiceImpl<ServerPermissionMapper, ServerPermission> implements ServerPermissionService {

    @Override
    public ServerPermission createPermission(ServerPermission permission) {
        return null;
    }

    @Override
    public void deletePermission(Long permissionId) {

    }
}
