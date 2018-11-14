package com.mofei.chapter8;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mofei
 * @date 2018/11/14 20:55
 */
@Configuration
public class LoggerConfiguration implements WebMvcConfigurer{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInteceptor())
                .addPathPatterns("/**");
    }
}

