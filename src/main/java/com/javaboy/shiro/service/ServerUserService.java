package com.javaboy.shiro.service;

import com.javaboy.shiro.entity.ServerUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-09-27 03:02:23
 */
public interface ServerUserService extends IService<ServerUser> {

    List<ServerUser> queryServerUserByUserName(String username);
}
