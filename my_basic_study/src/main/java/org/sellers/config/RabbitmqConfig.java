package org.sellers.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 修改某些RabbitMQ的自动配置
 */
@Configuration
public class RabbitmqConfig {
    /**
     * 将默认JDK序列化规则转为Json序列化
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    //一下三个分别是创建rabbitMQ的队列、交换机，以及绑定
    @Bean
    @Qualifier("myQueue")
    public Queue myQueue() {
        return new Queue("myQueue", true);
    }

    @Bean
    @Qualifier("myExchange")
    public DirectExchange myExchange() {
        return new DirectExchange("myExchange", true, false);
    }

    //这个绑定指定的就是routingKey，当生产者发送消息时，指定这个key的话，交换机便会讲消息发到队列myQueue中
    @Bean
    @Qualifier("myBinding")
    public Binding myBinding(@Qualifier("myQueue") Queue queue,
                             @Qualifier("myExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("testKey");
    }
}
