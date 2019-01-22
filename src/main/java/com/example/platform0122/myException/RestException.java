package com.example.platform0122.myException;

/**
 * Created by huanglijun on 2019/1/22
 */
public class RestException extends Exception{
    int code; //状态码
    String message; //异常提示信息
    Boolean t;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getT() {
        return t;
    }

    public void setT(Boolean t) {
        this.t = t;
    }


    public RestException(String message) {
        this.message = message;
    }

    public RestException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public RestException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public RestException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}
