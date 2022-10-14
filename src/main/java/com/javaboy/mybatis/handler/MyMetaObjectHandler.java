package com.javaboy.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：元数据处理器
 * @date ：2022/10/14 11:18
 */
// 该注解说明可以使用slf4j日志打印
@Slf4j
// 该注解说明把处理器加载到IOC容器中
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ...");
        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "gmtCreate", Date.class, new Date());
        this.strictUpdateFill(metaObject, "gmtModified", Date.class, new Date());
    }

    // 填充时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ...");
        this.strictUpdateFill(metaObject, "gmtModified", Date.class, new Date());
    }

}
