package org.selelrs.mall.message.simple.transaction;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 事务消息发送，参考OneNote笔记 rocketMQ事务消息流程图
 */
public class TransactionProducer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        TransactionMQProducer producer = new TransactionMQProducer("transaction");
        producer.setNamesrvAddr("192.168.86.91:9876");
        //异步事务提交，提升性能
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2000),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("线程池");
                    return thread;
                }
        );
        producer.setExecutorService(threadPoolExecutor);
        //本地事务监听器
        producer.setTransactionListener(new TransactionListenerImpl());
        producer.start();
        String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "Tag0"};
        for (int i = 0; i < 10; i++) {
            Message message = new Message("transaction",
                    tags[i % tags.length],
                    (tags[i % tags.length] + "_transactionProducer").getBytes(StandardCharsets.UTF_8));
            TransactionSendResult transactionSendResult = producer.sendMessageInTransaction(message, null);
            System.out.println("事务消息发送成功：" + transactionSendResult);
            Thread.sleep(10L);
        }
        Thread.sleep(10000L);
        producer.shutdown();
    }
}
