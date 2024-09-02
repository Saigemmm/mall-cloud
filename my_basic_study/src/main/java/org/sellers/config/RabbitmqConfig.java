package org.sellers.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
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
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
