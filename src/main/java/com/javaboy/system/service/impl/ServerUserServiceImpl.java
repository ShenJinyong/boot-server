package com.javaboy.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.javaboy.system.entity.ServerUser;
import com.javaboy.system.mapper.ServerUserMapper;
import com.javaboy.system.service.ServerUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 沈金勇 438217638@qq.com
 * @since 2022-10-14 11:43:29
 */
@Service
public class ServerUserServiceImpl extends ServiceImpl<ServerUserMapper, ServerUser> implements ServerUserService {

    @Resource
    private ServerUserMapper serverUserMapper;

    @Override
    public ServerUser queryServerUserByUserName(String username) {
        QueryWrapper<ServerUser> serverUserQueryWrapper = new QueryWrapper<>();
        serverUserQueryWrapper.eq("username",username);
        return serverUserMapper.selectOne(serverUserQueryWrapper);
    }
}
