package org.selelrs.mall.message.simple;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 简单消费者，推模式
 */
public class Consumer {
    public static void main(String[] args) throws MQClientException {
        //拉模式：消费者主动从broker上拉取消息
        //推模式：消费者等待broker将消息推送过来
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("simpleConsumer");
        consumer.setNamesrvAddr("192.168.86.91:9876");
        consumer.subscribe("batch",
                "*");//*表示不进行消息过滤，任何消息都接收
        //消费方式设置，此处设置为并发消费
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
                    System.out.println("消息消费成功" + messageExt);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("consumer started.");
    }
}
