package com.javaboy.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：元数据处理
 * @date ：2022/9/14 14:30
 */
@Slf4j // 该注解说明可以使用slf4j日志打印
@Component // 该注解说明把处理器加载到IOC容器中
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ...");
        this.strictInsertFill(metaObject, "gmtCreate", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
        this.strictUpdateFill(metaObject, "gmtModified", Date.class, new Date());
    }

    // 填充时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ...");
        this.strictUpdateFill(metaObject, "gmtModified", Date.class, new Date());
    }

}
