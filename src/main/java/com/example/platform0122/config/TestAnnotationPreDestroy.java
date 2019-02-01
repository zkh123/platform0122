package com.example.platform0122.config;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Created by huanglijun on 2019/2/1
 */
@Component
public class TestAnnotationPreDestroy {

    @PreDestroy
    public void destory(){
        System.out.println("我被销毁了、、、、、我是用的@PreDestory的方式、、、、、、");
        System.out.println("我被销毁了、、、、、我是用的@PreDestory的方式、、、、、、");
    }

}
