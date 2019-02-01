package com.example.platform0122.dao.drools;

import com.example.platform0122.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by huanglijun on 2019/2/1
 */
public interface UserMapper {
    Integer insertOne(User user);
    User selectOneById(@Param(value = "id")int id);
}
