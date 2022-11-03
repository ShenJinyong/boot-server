package com.javaboy.kafka.controller;

import com.javaboy.common.domain.ResponseEntity;
import com.javaboy.kafka.util.KafkaSender;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：
 * @date ：2022/11/3 15:24
 */
public class KafkaController {

    @Resource
    private KafkaSender kafkaSender;

    @ApiOperation(value = "测试-kafka发送消息")
    @PostMapping("/kafkaSender")
    public ResponseEntity kafkaSender1(){
        kafkaSender.sendMessage("kafka-grab-single-disputes","codvision-hello-20221101");
        return ResponseEntity.ok();
    }

}
