package com.javaboy.kafka.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author ：沈金勇 438217638@qq.com
 * @description：kafka消费工具类
 * @date ：2022/11/3 15:21
 */
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topicPattern = "kafka-grab-single-disputes")
    public void kafkaGrabSingleDisputes(ConsumerRecord<?, ?> record){
        log.info("简单消费：主题【{}】-分区【{}】-value【{}】",record.topic(),record.partition(),record.value());
    }

}
