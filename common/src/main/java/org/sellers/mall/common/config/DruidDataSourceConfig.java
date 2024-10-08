package org.sellers.mall.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidDataSourceConfig {
    @ConfigurationProperties("spring.datasource.druid")
    @Bean
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
