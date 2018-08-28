package com.zhuochen.um.backend.config;

import com.zhuochen.um.backend.config.interceptor.AuthorityInterceptor;
import com.zhuochen.um.backend.config.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthorityInterceptor authorityInterceptor;

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .excludePathPatterns("/", "/swagger**/**", "/v2/api-docs**", "/error");

        registry.addInterceptor(authorityInterceptor)
                .excludePathPatterns("/", "/swagger**/**", "/v2/api-docs**", "/error", "/login", "/logout");
    }
}
