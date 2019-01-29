package com.example.platform0122.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huanglijun on 2019/1/29
 */
@Configuration
public class UrlConfig {
    @Value("${user.queryData.url}")
    private String userQueryData;
    @Value("${message.pushWeixin.url}")
    private String messagePushWeixin;


    public String getUserQueryData() {
        return userQueryData;
    }

    public void setUserQueryData(String userQueryData) {
        this.userQueryData = userQueryData;
    }

    public String getMessagePushWeixin() {
        return messagePushWeixin;
    }

    public void setMessagePushWeixin(String messagePushWeixin) {
        this.messagePushWeixin = messagePushWeixin;
    }
}
