package com.example.platform0122.entity;

/**
 * Created by huanglijun on 2019/2/1
 */
public enum TypeEnum {

    XBSP("详版审批",1),TIAOE("系统调额",2),DAE("大额调额",3),TARS("tars调额",4),NRT("准实时调额",5);

    private String value;
    private int key;

    TypeEnum(String value, int key) {
        this.value = value;
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
