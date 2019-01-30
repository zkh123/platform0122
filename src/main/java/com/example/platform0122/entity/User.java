package com.example.platform0122.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "昵称不能为空")
    private String nickname;
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6,max = 18,message = "密码长度不能小于6位 且不能大于18位")
    private String password;
    private String salt;
    private String headpic;
    private Integer sex;      //1=女，2=男
    @Min(value = 18,message = "必须年满18岁！")
    @Max(value = 100,message = "年龄不能大于100岁")
    private Integer age;
    private Integer height;
    private Integer status;
    private Integer level;        //会员等级
    private Integer integral;     //积分
    private Date createTime;
    private Long manageId;       //管理师id
    private String manageName;   //管理师名称
}
