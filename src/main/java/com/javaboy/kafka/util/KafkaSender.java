package com.javaboy.kafka.util;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.Nullable;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description： Kafka发送工具类
 * @date ：2022/11/3 15:18
 */
public class KafkaSender {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public ListenableFuture<SendResult<String, String>> sendMessage(String topic, @Nullable String message){
        return kafkaTemplate.send(topic,message);
    }

}
