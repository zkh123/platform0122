package com.example.platform0122.dao.news;

import com.example.platform0122.entity.AppAdjRecord;
import org.apache.ibatis.annotations.Param;

/**
 * Created by huanglijun on 2019/1/22
 */
public interface AppAdjRecordMapper {

    AppAdjRecord selectById(@Param(value = "id") int id);
}
