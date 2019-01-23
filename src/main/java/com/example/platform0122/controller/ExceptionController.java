package com.example.platform0122.controller;

import com.example.platform0122.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "异常测试",notes = "代码中任意地方的异常,不做try catch处理")
    @GetMapping(value = "test1")
    public Object test1(){
        int a = 1/0;
        return a;
    }

    @ApiOperation(value = "异常测试",notes = "success or error")
    @GetMapping(value = "test2")
    public Object test2(@RequestParam(value = "username")String username){
        if (username.equals("hlj")){
            return ResultUtil.success("请求用户名正确");
        }else {
            return ResultUtil.error(500,"请求用户名不正确");
        }
    }

}
