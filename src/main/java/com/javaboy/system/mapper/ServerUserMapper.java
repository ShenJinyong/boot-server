package com.javaboy.system.mapper;

import com.javaboy.system.entity.ServerUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 沈金勇 438217638@qq.com
 * @since 2022-10-14 11:43:29
 */
@Mapper
public interface ServerUserMapper extends BaseMapper<ServerUser> {

}