package com.javaboy.kafka.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.lang.Nullable;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：Kafka结果拦截器
 * @date ：2022/11/3 15:23
 */
@Slf4j
public class KafkaResultHandler implements ProducerListener {

    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        //成功时处理
        log.info("【成功】主题：{},分区:{}",recordMetadata.topic(),recordMetadata.partition());
    }

    @Override
    public void onError(ProducerRecord producerRecord, @Nullable RecordMetadata recordMetadata, Exception exception) {
        //失败时处理
        if(exception == null){
            log.info("【失败】主题：{},分区:{}",recordMetadata.topic(),recordMetadata.partition());
        }
    }

}
