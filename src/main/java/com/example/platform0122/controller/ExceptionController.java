package com.example.platform0122.controller;

import com.example.platform0122.myException.RestException;
import com.example.platform0122.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huanglijun on 2019/1/22
 */
@RestController
@RequestMapping(value = "exception")
public class ExceptionController {

    @GetMapping(value = "test1")
    public Object test1() throws RestException {
        int a = 0;
        try {
            a = 1/0;
        }catch (Exception e){
            throw new RestException(e.toString());
        }
        return a;
    }

    @GetMapping(value = "test2")
    public Object test2(@RequestParam(value = "username")String username){
        if (username.equals("hlj")){
            return ResultUtil.success("请求用户名正确");
        }else {
            return ResultUtil.error(500,"请求用户名不正确");
        }
    }

}
