package com.example.platform0122.service;

import com.example.platform0122.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by huanglijun on 2019/1/30
 */
@Service
public class LoginService {

    public User findUserByToken(String token){
        User user = new User();
        user.setAge(18);
        return user;
    }

    public void resetKeyTime(String token){
        //设置过期时间
    }
}
