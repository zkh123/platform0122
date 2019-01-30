package com.example.platform0122.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huanglijun on 2019/1/30
 */
@Setter
@Getter
public class User implements Serializable {
    private Long uId;
    private String telephone;
    private String nickname;
    private String password;
    private String salt;
    private String headpic;
    private Integer sex;      //1=女，2=男
    private Integer age;
    private Integer height;
    private Integer status;
    private Integer level;        //会员等级
    private Integer integral;     //积分
    private Date createTime;
    private Long manageId;       //管理师id
    private String manageName;   //管理师名称
}
