package com.example.platform0122.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by huanglijun on 2019/2/1
 */
@Getter
@Setter
public class DroolsVersionRecord {

    private int id;
    private int type;
    private int userId;
    private String username;
    private String drlVersion;
    private Date insertTime;
    private Date updateTime;
    private boolean isActive;
}
