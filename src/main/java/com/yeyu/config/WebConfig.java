package com.yeyu.config;

import com.yeyu.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")//拦截所有请求
                // 放行登录及前端静态资源（index.html、favicon、assets 等）
                .excludePathPatterns(
                        "/login",
                        "/api/login",
                        "/",
                        "/index.html",
                        "/favicon.ico",
                        "/assets/**",
                        "/static/**",
                        "/css/**",
                        "/js/**",
                        "/img/**",
                        "/images/**"
                );
    }
}
