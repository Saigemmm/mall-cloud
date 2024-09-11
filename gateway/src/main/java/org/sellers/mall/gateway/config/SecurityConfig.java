package org.sellers.mall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 配置只有token验证过的请求才会通过
 */
//@EnableWebFluxSecurity //Spring Cloud Gateway是基于Flux实现的
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/oauth2/token").permitAll()
                .anyRequest().authenticated()
                .and().oauth2ResourceServer().jwt();
        return http.build();
    }
}

