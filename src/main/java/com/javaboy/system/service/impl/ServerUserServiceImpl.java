package com.javaboy.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.javaboy.system.entity.ServerUser;
import com.javaboy.system.mapper.ServerUserMapper;
import com.javaboy.system.service.ServerUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-10-17 04:42:44
 */
@Service
public class ServerUserServiceImpl extends ServiceImpl<ServerUserMapper, ServerUser> implements ServerUserService {

    @Resource
    private ServerUserMapper serverUserMapper;

    @Override
    public int createUser(ServerUser user) {
        return serverUserMapper.insert(user);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {

    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public void unCorrelationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public ServerUser findByUsername(String username) {
        QueryWrapper<ServerUser> serverUserQueryWrapper = new QueryWrapper<>();
        serverUserQueryWrapper.eq("username",username);
        return serverUserMapper.selectOne(serverUserQueryWrapper);
    }

    @Override
    public Set<String> findRoles(String username) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }

}
