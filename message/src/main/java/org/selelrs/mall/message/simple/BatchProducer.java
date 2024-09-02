package org.selelrs.mall.message.simple;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.selelrs.mall.message.util.ListSplitter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息批量发送
 * 批量发送不能是延时消息、事务消息
 */
public class BatchProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("BatchProducer");
        //需要开启端口包括nameserver,9876,10911
        producer.setNamesrvAddr("192.168.86.91:9876");
        producer.start();
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Message message = new Message("batch", "tags", (i + "batchProducer").getBytes(StandardCharsets.UTF_8));
            messages.add(message);
        }
        ListSplitter listSplitter = new ListSplitter(messages);
        while (listSplitter.hasNext()) {
            List<Message> next = listSplitter.next();
            SendResult send = producer.send(next);
            System.out.println("message send successfully: " + send);
        }
        producer.shutdown();
    }
}
