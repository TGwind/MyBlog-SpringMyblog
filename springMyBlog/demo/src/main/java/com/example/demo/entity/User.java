package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("user")
@Data  //自动生成getter、setter
public class User implements Serializable {
    @TableId(type = IdType.AUTO) //设置主键、自动生成
    private Long uid;  //要使用包装类
    private String userName;
    private String userPassword;
    private Integer age;
    private String school;
    private String degree;
    private String profession;
}
