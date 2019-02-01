package com.example.platform0122.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by huanglijun on 2019/1/30
 */
@Setter
@Getter
public class User implements Serializable {

    private int id;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6,max = 18,message = "密码长度不能小于6位 且不能大于18位")
    private String password;
    @Pattern(regexp = "^(.+)@(.+)$",message = "邮箱的格式不合法")
    private String email;
    private Date insertTime;
    private Date updateTime;
    private boolean isActive;
    @Length(min = 11,max = 11,message = "手机号必须为11位")
    private long phone;

}
