package com.javaboy.shiro.service.impl;

import com.javaboy.shiro.entity.ServerRole;
import com.javaboy.shiro.mapper.ServerRoleMapper;
import com.javaboy.shiro.service.ServerRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-09-27 03:02:23
 */
@Service
public class ServerRoleServiceImpl extends ServiceImpl<ServerRoleMapper, ServerRole> implements ServerRoleService {

    @Resource
    private ServerRoleMapper serverRoleMapper;

    public Set<String> selectRolePermissionByUserId(String userId){
        return serverRoleMapper.selectRolePermissionByUserId(userId);
    }
}
