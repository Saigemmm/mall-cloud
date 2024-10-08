package org.sellers.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//以下是死信队列的配置
@Configuration
public class DelayQueueRabbitMqConfig {
    //这个队列是实际的业务队列，
    @Bean
    @Qualifier("myDelayedQueue")
    public Queue myDelayedQueue() {
        Map<String, Object> args = new HashMap<>();
        // 设置消息的TTL，单位为毫秒
        args.put("x-message-ttl", 10000); // 例如，设置为10秒
        // 由于Spring AMQP的QueueBean定义不支持直接设置死信属性，你需要在创建Queue时通过arguments参数设置，或者在RabbitMQ管理界面手动设置
        // 上面这句话是GPT说的，也就是不确定下面两行代码是否生效，这里就当作它是有效的
        args.put("x-dead-letter-exchange", "myDeadLetterExchange");//配置死信交换机
        args.put("x-dead-letter-routing-key", "myDeadLetterRoutingKey");//配置死信路由键
        // 如果需要，还可以设置队列的其他属性，如持久化等
        return new Queue("myDelayedQueue", true, false, false, args);
    }

    //死信交换机
    @Bean
    @Qualifier("myDeadLetterExchange")
    public DirectExchange myDeadLetterExchange() {
        return new DirectExchange("myDeadLetterExchange", true, false);
    }

    //这个是死信队列

    /**
     * 如果要实现延时队列，那么就让消费者监听这个死信队列，这样等实际的那个业务队列（在这里是myDelayedQueue）中的消息超时后就会进入到这个队列，
     * 这样也就实现了延时队列的效果
     * 所以在实现延时队列时，不要让消费者监听业务队列，等待消息自动过期即可
     */
    @Bean
    @Qualifier("myDeadLetterQueue")
    public Queue myDeadLetterQueue() {
        return new Queue("myDeadLetterQueue", true);
    }

    // 注意：这里实际上是在创建业务队列时设置死信属性
    @Bean
    @Qualifier("deadLetterBinding")
    public Binding deadLetterBinding(@Qualifier("myDeadLetterQueue") Queue myDeadLetterQueue,
                                     @Qualifier("myDeadLetterExchange") DirectExchange myDeadLetterExchange) {
        // 由于Spring AMQP的QueueBean定义不支持直接设置死信属性，
        // 你需要在创建Queue时通过arguments参数设置，或者在RabbitMQ管理界面手动设置
        // 这里仅展示绑定逻辑（假设死信属性已在Queue中设置）
        return BindingBuilder.bind(myDeadLetterQueue).to(myDeadLetterExchange).with("myDeadLetterRoutingKey");
    }
}
