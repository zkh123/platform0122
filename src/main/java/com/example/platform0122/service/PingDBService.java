package com.example.platform0122.service;

import com.example.platform0122.dao.local.PingDBMapper;
import com.example.platform0122.entity.PingDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huanglijun on 2019/1/22
 */
@Service
public class PingDBService {

    @Autowired
    private PingDBMapper pingDBMapper;

    public PingDB queryPushData(){
        return pingDBMapper.queryPushData();
    }
}
