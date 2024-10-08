package org.sellers.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DelayQueueService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void delayQueueTest(){
        rabbitTemplate.convertAndSend("myDelayedQueue", "", "Hello, this is a delayed message!");
    }

    @RabbitListener(queues = "myDeadLetterQueue")
    public void listenDeadLetterQueue(String message) {
        // 处理死信队列中的消息
        System.out.println("Received dead letter: " + message);
    }
}
