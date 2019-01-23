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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
