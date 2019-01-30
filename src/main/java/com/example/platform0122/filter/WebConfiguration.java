package com.example.platform0122.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Created by huanglijun on 2019/1/30
 */
@Configuration
public class WebConfiguration {

    @Order(value = 6)
    @Bean
    public FilterRegistrationBean test1FilterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter1());
        registration.addUrlPatterns("/*");
        registration.setName("myFilter1");
        registration.addInitParameter("username","hlj");
        return registration;
    }

    @Order(value = 1)
    @Bean
    public FilterRegistrationBean test2FilterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter2());
        registration.addUrlPatterns("/*");
        registration.setName("myFilter2");
        registration.addInitParameter("qq","849902930");
        return registration;
    }
}
