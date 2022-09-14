package com.javaboy.mybatis;

import com.javaboy.core.entity.po.SysDictPo;
import com.javaboy.core.mapper.SysDictMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： 乐观锁测试
 * @date ：2022/9/14 15:39
 */
@SpringBootTest
public class VersionTest {

    @Autowired
    private SysDictMapper sysDictMapper;

    @Test
    public void testVersionInsert() {
        System.out.println(("----- testVersionInsert method test ------"));
        SysDictPo sysDictPo = new SysDictPo();
        sysDictPo.setTableName("user");
        sysDictPo.setTableKey("1");
        sysDictPo.setTableValue("是否");
        sysDictMapper.insert(sysDictPo);
        List<SysDictPo> sysDictPos = sysDictMapper.selectList(null);
        sysDictPos.forEach(System.out::println);
    }

    @Test
    public void testVersionUpdate() {
        System.out.println(("----- testVersion method test ------"));
        SysDictPo sysDictPo = sysDictMapper.selectById("1569962785592299521");
        sysDictPo.setTableKey("2");
        sysDictPo.setTableValue("有无");
        sysDictMapper.updateById(sysDictPo);
        List<SysDictPo> sysDictPos = sysDictMapper.selectList(null);
        sysDictPos.forEach(System.out::println);
    }
}
