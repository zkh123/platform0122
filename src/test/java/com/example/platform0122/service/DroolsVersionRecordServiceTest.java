package com.example.platform0122.service;

import com.alibaba.fastjson.JSONObject;
import com.example.platform0122.Platform0122ApplicationTests;
import com.example.platform0122.entity.DroolsVersionRecord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by huanglijun on 2019/2/1
 */
public class DroolsVersionRecordServiceTest extends Platform0122ApplicationTests {

    @Autowired
    private DroolsVersionRecordService droolsVersionRecordService;

    @Test
    public void insertOne() {
        DroolsVersionRecord droolsVersionRecord = new DroolsVersionRecord();
        droolsVersionRecord.setDrlVersion("hlj-test-1.0.0.4.drl");
        droolsVersionRecord.setType(1);
        droolsVersionRecord.setUserId(123456);
        droolsVersionRecord.setUsername("huanglijun");
        Integer size = droolsVersionRecordService.insertOne(droolsVersionRecord);
        System.out.println("insertOne size: " + size);
    }

    @Test
    public void selectOneByType() {
        int type = 1;
        DroolsVersionRecord droolsVersionRecord = droolsVersionRecordService.selectOneByType(type);
        System.out.println("selectOneByType result: " + JSONObject.toJSONString(droolsVersionRecord));
    }
}