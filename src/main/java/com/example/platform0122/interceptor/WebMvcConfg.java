package com.example.platform0122.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huanglijun on 2019/1/30
 */
@Configuration
public class WebMvcConfg implements WebMvcConfigurer {

    @Bean
    public NeedLoginInterceptor needLoginInterceptor(){
        return new NeedLoginInterceptor();
    }

    @Bean
    public Test2Interceptor test2Interceptor(){
        return new Test2Interceptor();
    }

    /**
     * 配置静态资源位置
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List add = new ArrayList<>();
//        add.add("/js/**");
//        add.add("/pages/**");
//        add.add("/css/**");
//        add.add("/charts/**");
//        add.add("/sys/login.json");
//        add.add("/flashPlayer/**");
//        add.add("/easyUi/**");
//        add.add("/font/**");
//        add.add("/images/**");
//        add.add("/plugin/**");
//        add.add("/index.html");
//        add.add("/show.html");
        add.add("/test/**");
//        List exclude = new ArrayList<>();
//        exclude.add("/**");
        registry.addInterceptor(needLoginInterceptor()).addPathPatterns(add);
        registry.addInterceptor(test2Interceptor()).addPathPatterns(add);
    }
}
