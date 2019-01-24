package com.example.platform0122.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by huanglijun on 2019/1/22
 * 评级表
 */
@Getter
@Setter
public class PingDB {
    private int id;  //自增主键
    private int userid;  //用户标识
    private int listingid;  //标的
    private int bizid;  //业务标识
    private int zuid;  //业务分组
    private int dingid;  //业务定义
    private int months;  //区分业务
    private float creditScore;  //信用分数
    private String creditLevel;  //信用评级
    private int creditBin;  //bin值
    private String creditLevelPro;  //前台评级
    private String modelLabel;  //模型标签
    private String modelVer;  //模型版本
    private int processFlag;  //审批结论
    private int blockDays;  //禁言天数
    private String info;  //扩展Json
    private Date insertTime;  //插入时间
    private Date updateTime;  //更新时间
    private boolean isActive; //逻辑删除

    private String tabIndex;
}
