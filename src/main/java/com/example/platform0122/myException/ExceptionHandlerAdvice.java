package com.example.platform0122.myException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huanglijun on 2019/1/22
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(RestException.class)
    @ResponseBody
    public Map<String,Object> restError(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Exception ex){
        RestException restException = (RestException)ex;
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("exception",null != restException.getT() ? restException.getT() : restException);
        map.put("errorMessage",restException.getMessage());
        map.put("url",request.getRequestURL());
        map.put("statusCode",restException.getCode());

        return map;
    }
}
