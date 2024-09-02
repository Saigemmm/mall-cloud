package org.sellers.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置分布式锁Redisson
 */
@Configuration
public class RedissonConfig {
    //此为单机模式下的redisson
    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.86.140:6379").setDatabase(0);
        return (Redisson) Redisson.create();
    }
}
