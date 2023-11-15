package com.cetus.config;

import com.cetus.filter.CetusSecurityFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.annotation.Resource;

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class CetusSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private CetusSecurityFilter cetusSecurityFilter;

    @Bean
    public FilterRegistrationBean<CetusSecurityFilter> cetusSecurityFilterBean() {
        FilterRegistrationBean<CetusSecurityFilter> cetusSecurityFilterBean = new FilterRegistrationBean<>(cetusSecurityFilter);
        cetusSecurityFilterBean.addUrlPatterns("/**");
        return cetusSecurityFilterBean;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // CSRF禁用，因为不使用session
                .csrf().disable()
                // 禁用HTTP响应标头
                .headers().cacheControl().disable()
                .and()
                // 认证失败处理类
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 过滤请求
                .authorizeRequests()
                // 对于登录login 注册register 验证码captchaImage 允许匿名访问
//                .antMatchers("/login", "/register", "/captchaImage", "/pill/**").permitAll()
                .antMatchers("/login").permitAll()
                // 静态资源，可匿名访问
                .antMatchers(HttpMethod.GET, "/", "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/profile/**").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                .and()
                // 禁用HTTP响应中的X-Frame-Options头部，不允许网页被嵌入到任何iframe或frame中
                .headers().frameOptions().disable();
    }
}
