package com.example.platform0122.controller;

import com.example.platform0122.service.PingDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huanglijun on 2019/1/22
 */
@RestController
@RequestMapping(value = "pingDB")
public class PingDBController {

    @Autowired
    private PingDBService pingDBService;

    @GetMapping(value = "/selectOne")
    public Object queryPushData(){
        return pingDBService.queryPushData();
    }


    @GetMapping(value = "getPingData")
    public Object getPingData(@RequestParam(value = "userid")int userid,@RequestParam(value = "bizid")int bizid){
        return pingDBService.getPingData(userid,bizid);
    }
}
