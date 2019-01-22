package com.example.platform0122.service;

import com.example.platform0122.dao.news.AppAdjRecordMapper;
import com.example.platform0122.entity.AppAdjRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huanglijun on 2019/1/22
 */
@Service
public class AppAdjRecordService {

    @Autowired
    private AppAdjRecordMapper appAdjRecordMapper;

    public AppAdjRecord queryPushData(){
        return appAdjRecordMapper.queryPushData();
    }

}
