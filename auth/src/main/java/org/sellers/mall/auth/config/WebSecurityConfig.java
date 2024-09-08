package org.sellers.mall.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated() //任何请求都需要身份验证
                .and().authorizeRequests().antMatchers("/oauth/**").permitAll() //认证接口放行
                .and().oauth2Login() //启用 OAuth2 登录，默认使用授权码模式
//                .and().formLogin().permitAll() //表单登录放行
//                .and().logout().permitAll() //注销放行 formLogin和logout（配套使用）不是 OAuth2 的认证模式，而是 Spring Security 用于配置表单登录的方式
                .and().csrf().disable(); //拒绝跨域
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        //oauth2密码模式需要拿到这个
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
