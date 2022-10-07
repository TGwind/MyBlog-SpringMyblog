package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("skill")
@Data  //自动生成getter、setter
public class Skill implements Serializable {
    @TableId(type = IdType.AUTO) //设置主键、自动生成
    private Long id;
    private Long uid;  //要使用包装类
    private String name;
    private Integer type;
    private String style;

}
