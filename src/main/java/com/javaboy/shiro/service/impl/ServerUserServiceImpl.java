package com.javaboy.shiro.service.impl;

import com.javaboy.shiro.entity.ServerUser;
import com.javaboy.shiro.mapper.ServerUserMapper;
import com.javaboy.shiro.service.ServerUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-09-27 03:02:23
 */
@Service
public class ServerUserServiceImpl extends ServiceImpl<ServerUserMapper, ServerUser> implements ServerUserService {

    @Resource
    private ServerUserMapper serverUserMapper;

    @Override
    public List<ServerUser> queryServerUserByUserName(String username) {
        return serverUserMapper.queryServerUserByUserName(username);
    }
}
