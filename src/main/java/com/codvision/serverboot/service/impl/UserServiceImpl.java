package com.codvision.serverboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codvision.serverboot.dao.User;
import com.codvision.serverboot.mapper.UserMapper;
import com.codvision.serverboot.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author ：沈金勇 438217638@qq.com
 * @Description：用户表Service接口实现类
 * @Date ：2022/8/5 14:47
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
