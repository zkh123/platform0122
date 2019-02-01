package com.example.platform0122.service;

import com.example.platform0122.dao.drools.DroolsVersionRecordMapper;
import com.example.platform0122.entity.DroolsVersionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huanglijun on 2019/2/1
 */
@Service
public class DroolsVersionRecordService {

    @Autowired
    private DroolsVersionRecordMapper droolsVersionRecordMapper;


    public Integer insertOne(DroolsVersionRecord droolsVersionRecord){
        return droolsVersionRecordMapper.insertOne(droolsVersionRecord);
    }

    public DroolsVersionRecord selectOneByType(int type){
        return droolsVersionRecordMapper.selectOneByType(type);
    }
}
