package org.selelrs.mall.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("org.sellers.mall")
public class MessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class);
    }
}
