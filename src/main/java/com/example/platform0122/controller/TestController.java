package com.example.platform0122.controller;

import com.example.platform0122.config.UrlConfig;
import com.example.platform0122.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huanglijun on 2019/1/29
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private UrlConfig urlConfig;

    @GetMapping(value = "urlConfig")
    public Object UrlConfigTest(){
        Map<String,Object> param = new HashMap<>();
        param.put("queryData",urlConfig.getUserQueryData());
        param.put("pushWeixin",urlConfig.getMessagePushWeixin());
        return param;
    }


    @GetMapping(value = "filterAndInterceptor")
    public Object filterAndInterceptor(){
        return ResultUtil.success();
    }
}