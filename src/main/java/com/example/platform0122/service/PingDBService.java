package com.example.platform0122.service;

import com.example.platform0122.dao.local.PingDBMapper;
import com.example.platform0122.entity.PingDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by huanglijun on 2019/1/22
 */
@Service
public class PingDBService {

    private final Logger logger = LoggerFactory.getLogger(PingDBService.class);

    @Autowired
    private PingDBMapper pingDBMapper;

    public PingDB queryPushData(){
        return pingDBMapper.queryPushData();
    }


    public PingDB getPingData(int userid,int bizid){
        Map<String,Object> map = new HashMap<>();
        map.put("userid",userid);
        map.put("bizid",bizid);
        map.put("tabIndex",getTabIndex(userid));
//        return pingDBMapper.getPingData(userid,bizid,getTabIndex(userid));
        return pingDBMapper.getPingData(map);
    }

    private String getTabIndex(int userid){
        String data = "";
        int temp = userid%100;
        if (temp >= 0 && temp < 10){
            data = data + "00" + temp;
        }else if (temp >= 10 && temp < 100){
            data = data + "0" + temp;
        }else {
            data = data + temp;
        }
        logger.info("userid: " + userid + " ,data: " + data);
        return data;
    }
}
