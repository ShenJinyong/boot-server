package com.codvision.serverboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codvision.serverboot.dao.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：用户表Mapper
 * @date ：2022/8/5 14:38
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
