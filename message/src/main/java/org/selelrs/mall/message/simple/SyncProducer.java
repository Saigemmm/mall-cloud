package org.selelrs.mall.message.simple;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * 消息发送案例：同步发送
 * <p>
 * rocketMQ消息默认持久化路径：/root/store/commitlog 和 /root/store/consumequeque
 * consumequeque中并不需要存储消息的内容，而存储的是消息在commitlog中的offset。也就是说，ConsumeQueue其实是CommitLog的一个索引文件。
 * <p>
 * 要求：
 * 1.可靠性要求高
 * 2.数据量较少
 * 3.实时响应
 */
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("SyncProducer");
        //需要开启端口包括nameserver,9876,10911
        producer.setNamesrvAddr("192.168.86.91:9876");
        producer.start();
        for (int i = 0; i < 2; i++) {
            Message message = new Message("simple",
                    "tags",
                    (i + "_SyncProducer").getBytes(StandardCharsets.UTF_8));
            SendResult result = producer.send(message, 10000);
            //单向发送，没有返回值
//            producer.sendOneway(message);
            System.out.println(i + "_消息发送成功" + result);
        }
        producer.shutdown();
    }
}
