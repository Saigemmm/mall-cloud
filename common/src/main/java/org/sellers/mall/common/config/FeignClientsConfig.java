package org.sellers.mall.common.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "org.sellers.mall")
public class FeignClientsConfig {
}
