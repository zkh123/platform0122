package com.example.platform0122.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by huanglijun on 2019/1/22
 */
@Getter
@Setter
public class AppAdjRecord {

    private int id;  //自增主键
    private int userId;  //用户标识
    private int type;  //类型 1：系统调额, 2：pp卡调额
    private String droolsData;  //drools出参
    private Date insertTime;  //插入时间
    private Date updateTime;  //更新时间
    private boolean isActive; //逻辑删除
}
