package com.example.platform0122.controller;

import com.example.platform0122.service.AppAdjRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huanglijun on 2019/1/22
 */
@RestController
public class AppAdjRecordController {

    @Autowired
    private AppAdjRecordService appAdjRecordService;

    @GetMapping(value = "app")
    public Object queryPushData(){
        return appAdjRecordService.queryPushData();
    }

}
