package com.javaboy.mongodb.controller;

import com.javaboy.common.domain.ResponseEntity;
import com.javaboy.mongodb.entity.Locate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：MongoDB
 * @date ：2022/11/14 16:36
 */
@Tag(name = "Mongo管理")
@RestController
@RequestMapping("/mongodb")
public class MongoController {

    @Resource
    private MongoTemplate mongoTemplate;

    @Operation(summary = "Mongodb集合测试")
    @GetMapping("/createCollection")
    public ResponseEntity mongodbCollection(){
        boolean serverboot = mongoTemplate.collectionExists("serverboot");
        if(serverboot){
            mongoTemplate.dropCollection("serverboot");
        }
        mongoTemplate.createCollection("serverboot");
        return ResponseEntity.ok();
    }

    @Operation(summary = "Mongodb文档测试")
    @GetMapping("/insertDocument")
    public ResponseEntity mongodbDocument(){
        Locate locate = new Locate("123456789","18365418110","wifi",20.00D,20.00D,"杭州",new Date());
        mongoTemplate.save(locate);
        // _id存在时会报错
        mongoTemplate.insert(locate);
        return ResponseEntity.ok();
    }

    @Operation(summary = "Mongodb文档查询测试")
    @GetMapping("/queryDocument")
    public ResponseEntity mongodbQueryDocument(){
        List<Locate> all = mongoTemplate.findAll(Locate.class);
        return ResponseEntity.ok(all);
    }

}
