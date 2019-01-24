package com.example.platform0122.dao.local;

import com.example.platform0122.entity.PingDB;

import java.util.Map;

/**
 * Created by huanglijun on 2019/1/22
 */
public interface PingDBMapper {
    PingDB queryPushData();

//    PingDB getPingData(@Param(value = "userid") int userid, @Param(value = "bizid") int bizid, @Param(value = "tabIndex") String tabIndex);

    PingDB getPingData(Map<String,Object> map);

    Integer insertOne(PingDB pingDB);
}
