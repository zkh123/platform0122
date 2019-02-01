package com.example.platform0122.service;

import com.alibaba.fastjson.JSONObject;
import com.example.platform0122.Platform0122ApplicationTests;
import com.example.platform0122.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.provider.MD5;

import static org.junit.Assert.*;

/**
 * Created by huanglijun on 2019/2/1
 */
public class UserServiceTest extends Platform0122ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void insertOne() {
        User user = new User();
        user.setEmail("daCheng@qq.com");
        user.setUsername("daCheng");
        user.setPassword("000111");
        user.setPhone(15721463058l);
        int size = userService.insertOne(user);
        System.out.println("insertOne size : " + size);
    }


    @Test
    public void selectOneById() {
        int id = 1;
        User user = userService.selectOneById(id);
        System.out.println("selectOneById result: " + JSONObject.toJSONString(user));
    }

}