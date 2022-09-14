package com.javaboy.mybatis;

import com.javaboy.core.mapper.SysDictMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： 逻辑删除测试
 * @date ：2022/9/14 16:05
 */
@SpringBootTest
public class DeletedTest {

    @Autowired
    private SysDictMapper sysDictMapper;

    @Test
    public void testDeleted() {
        System.out.println(("----- testDeleted method test ------"));
        int i = sysDictMapper.deleteById("1569963266980937729");
    }
}
