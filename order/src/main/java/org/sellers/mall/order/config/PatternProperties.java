package org.sellers.mall.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pattern")  //nacos 动态刷新方式2,这个更简单，不会重新创建application context environment
public class PatternProperties {
    private String dateFormat;
}
