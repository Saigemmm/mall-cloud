package org.selelrs.mall.message.simple;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 异步发送
 */
public class AsyncProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("AsyncProducer");
        //需要开启端口包括nameserver,9876,10911
        producer.setNamesrvAddr("192.168.86.91:9876");
        producer.start();
        //计数器
//        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            final int index = i;//匿名内部类调用，变量声明为final
            Message message = new Message("simple",
                    "tagA",
                    (i + "AsyncProducer").getBytes(StandardCharsets.UTF_8));
            //异步发送
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
//                    countDownLatch.countDown();
                    System.out.println(index + "send success:" + sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
//                    countDownLatch.countDown();
                    System.out.println(index + "send failed" + Arrays.toString(throwable.getStackTrace()));
                }
            });
        }
//        countDownLatch.await(5, TimeUnit.SECONDS);
        Thread.sleep(5000L);
        producer.shutdown();
    }
}
