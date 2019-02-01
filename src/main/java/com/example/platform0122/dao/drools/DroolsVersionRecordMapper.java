package com.example.platform0122.dao.drools;


import com.example.platform0122.entity.DroolsVersionRecord;
import org.apache.ibatis.annotations.Param;

/**
 * Created by huanglijun on 2019/2/1
 */
public interface DroolsVersionRecordMapper {
    Integer insertOne(DroolsVersionRecord droolsVersionRecord);

    DroolsVersionRecord selectOneByType(@Param(value = "type") int type);
}
