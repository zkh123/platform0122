package com.example.platform0122.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by huanglijun on 2019/1/31
 */
@Setter
@Getter
public class League {

    //联赛id
    private int league_id;

    //联赛名称
    private String leagueName;

    //联赛简称
    private String shorterName;

    //开始日期
    private String startDate;

    //结束日期
    private String endDate;

    //主办方
    private String sponsor;

    //联赛章程
    private String constitution;

    //赛事性质
    private String level;

    //赛事性别
    private String gender;

    //几人制联赛
    private int number;

    //半场时间
    private String halfTime;

    //中场休息时间
    private String halfRelaxTime;

    //弃权默认比人
    private String abstentionScore;

}
