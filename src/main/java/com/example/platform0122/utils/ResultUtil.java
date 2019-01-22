package com.example.platform0122.utils;

import com.example.platform0122.myException.Msg;

/**
 * Created by huanglijun on 2019/1/22
 */
public class ResultUtil {

    /**
     * 请求成功
     * @param object
     * @return
     */
    public static Msg success(Object object){
        Msg msg = new Msg<>();
        msg.setCode(200);
        msg.setMsg("请求成功");
        msg.setData(object);

        return msg;
    }

    public static Msg success(){
        return success(null);
    }

    /**
     * 请求失败返回
     * @param code
     * @param resultMsg
     * @return
     */
    public static Msg error(Integer code,String resultMsg){
       Msg msg = new Msg<>();
       msg.setCode(code);
       msg.setMsg(resultMsg);
       return msg;
    }
}
