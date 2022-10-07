package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterMapper extends BaseMapper<User>  {
    // 查询用户名
    @Select("select user_password from user where user_name=#{user_name}")
    User selectByName(String username);
}
