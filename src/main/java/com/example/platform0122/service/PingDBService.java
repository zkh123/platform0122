package com.example.platform0122.service;

import com.alibaba.fastjson.JSONObject;
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

    public Integer insertOne(){
        PingDB pingDB = new PingDB();
        pingDB.setBizid(1203);
        pingDB.setListingid(-1);
        pingDB.setZuid(103);
        pingDB.setDingid(103);
        pingDB.setMonths(-2);
        pingDB.setCreditScore(0.1230000033974648f);
        pingDB.setCreditLevel("D");
        pingDB.setCreditBin(1);
        pingDB.setCreditLevelPro("AA");
        pingDB.setModelLabel("appyi");
        pingDB.setModelVer("v3_201808");
        pingDB.setProcessFlag(1);
        pingDB.setBlockDays(20);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("credit_jiangji","AA");
        jsonObject.put("credit_duotou","B");
        pingDB.setInfo(JSONObject.toJSONString(jsonObject));
        int userid = getUserId();
        pingDB.setUserid(userid);
        pingDB.setTabIndex(getTabIndex(userid));
        return pingDBMapper.insertOne(pingDB);
    }

    private int getUserId(){
        return (int) ((Math.random() * 9 + 1) * 100000);
    }
}
