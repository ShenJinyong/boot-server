package com.javaboy.shiro.service.impl;

import com.javaboy.shiro.entity.ServerAuth;
import com.javaboy.shiro.mapper.ServerAuthMapper;
import com.javaboy.shiro.service.ServerAuthService;
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
 * @since 2022-09-27 03:02:23
 */
@Service
public class ServerAuthServiceImpl extends ServiceImpl<ServerAuthMapper, ServerAuth> implements ServerAuthService {

    @Resource
    private ServerAuthMapper serverAuthMapper;

    @Override
    public Set<String> findUserPermissionsByUserId(String userId) {
        return serverAuthMapper.findUserPermissionsByUserId(userId);
    }
}
