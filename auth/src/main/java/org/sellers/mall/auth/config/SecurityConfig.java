package org.sellers.mall.auth.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * 处理基本的安全设置，包括用户身份验证和 JWT 的配置。
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /**
     * 只有/oauth/token和/oauth/authorize这两个路径的请求是公开的，其他所有路径的请求都需要经过认证。
     * 这些路径用于获取token和授权，是公开的，允许未经认证的用户访问。
     * 用户在访问其他受保护的资源时，必须提供有效的JWT token，否则将无法通过认证。
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests -> authorizeRequests
                        .antMatchers("/oauth/token").permitAll()  // 无需认证的路径
                        .anyRequest().authenticated())// 其他路径需要认证
                .formLogin().disable()
                .csrf(AbstractHttpConfigurer::disable)  // 关闭 CSRF 保护，适用于API场景
                .oauth2ResourceServer(oauth2 ->
                        // 使用自定义的 JWT 认证转换器
                        oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()))
                );
        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
        grantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256); //必须要使用256位的密钥，这个key是动态的，需要找地方存起来
        return NimbusJwtDecoder.withSecretKey(key).build();
    }

    public static void main(String[] args) {
        // 生成256位的密钥
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        System.out.println("Generated Key: " + key);
    }
}
