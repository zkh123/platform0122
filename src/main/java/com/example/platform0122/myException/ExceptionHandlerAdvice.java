package com.example.platform0122.myException;

import com.alibaba.fastjson.JSONObject;
import com.example.platform0122.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huanglijun on 2019/1/22
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Msg restError(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Exception ex){
        Msg msg = new Msg();
        msg.setMsg(ex.getMessage() + ex.toString());
        msg.setCode(ResultUtil.ERROR_CODE);
        msg.setData(ex.getStackTrace()[0].toString());

        logger.error("请求参数为: " + JSONObject.toJSONString(request.getParameterMap()) + " ,请求路径：" + request.getRequestURI());
        return msg;
    }
}
