package com.cetus.config;

import com.cetus.filter.CetusSecurityFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CetusSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁用跨站请求伪造保护
        http.csrf().disable();
        // 配置访问控制规则
        // 允许对/public/**下的资源进行匿名访问
        // 其他请求需要身份验证
        http.authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new CetusSecurityFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
