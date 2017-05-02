package com.nutmeg.logging.configuration;


import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.Filter;

import com.nutmeg.logging.filter.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class Config extends WebMvcConfigurerAdapter{

    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }

    @Bean
    public HandlerInterceptorAdapter requestInterceptor() {
        RequestInterceptor requestInterceptor = new RequestInterceptor();
        return requestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor());
    }
}
