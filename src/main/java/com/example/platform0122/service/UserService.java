package com.example.platform0122.service;

import com.example.platform0122.dao.drools.UserMapper;
import com.example.platform0122.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huanglijun on 2019/2/1
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Integer insertOne(User user){
        return userMapper.insertOne(user);
    }


    public User selectOneById(int id){
        return userMapper.selectOneById(id);
    }


}