package com.javaboy.shiro.service;

import com.javaboy.shiro.entity.ServerAuth;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 沈金勇438217638@qq.com
 * @since 2022-09-27 03:02:23
 */
public interface ServerAuthService extends IService<ServerAuth> {

    Set<String> findUserPermissionsByUserId(String userId);

}
