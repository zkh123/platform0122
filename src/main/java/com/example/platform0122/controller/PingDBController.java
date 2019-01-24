package com.example.platform0122.controller;

import com.example.platform0122.service.PingDBService;
import com.example.platform0122.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping(value = "insertOne")
    public Object insertOne(@RequestParam(value = "size")int size){
        int num = 0;
        for (int i = 0 ; i < size; i++){
            int number = pingDBService.insertOne();
            num = num + number;
        }
        return ResultUtil.success(num);
    }
}
