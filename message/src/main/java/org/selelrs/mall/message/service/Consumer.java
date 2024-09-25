package org.selelrs.mall.message.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(topic = "", consumerGroup = "cloud-simple-consumer")
public class Consumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        log.info("rocketMQ cloud-simple-consumer received message:{}", s);
    }
}
