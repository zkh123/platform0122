package com.example.platform0122.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by huanglijun on 2019/1/22
 */
@Getter
@Setter
public class ModelPsiVar {

    private int id;
    private int type;
    private String var;
    private Date insertTime;
    private Date updateTime;
    private boolean isActive;
}
