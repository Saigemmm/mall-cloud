package org.sellers.mall.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("org.sellers.mall")
@EnableAspectJAutoProxy//开启自动代理，就算没有该注解，@Aspect也有可能生效...
public class StorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class);
    }
}
