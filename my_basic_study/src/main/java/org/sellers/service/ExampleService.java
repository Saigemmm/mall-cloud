package org.sellers.service;

import org.sellers.mapper.TExampleMapper;
import org.sellers.domain.TExample;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 消息队列实例
 */
@Service
public class ExampleService {
    @Autowired
    private TExampleMapper exampleMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void insertExampleInRabbit(TExample example) {
        rabbitTemplate.convertAndSend("myExchange", "testKey", example);
        System.out.println("已经将example存入消息队列");
    }

    @RabbitListener(queues = "myQueue")//只要"myQueue"队列中有消息，则该方法就会被调用
    @Transactional
    public void receiveExample(TExample example) {
        exampleMapper.insert(example);
    }

    public List<TExample> selectAllExample() {
        return exampleMapper.selectAll();
    }
}
