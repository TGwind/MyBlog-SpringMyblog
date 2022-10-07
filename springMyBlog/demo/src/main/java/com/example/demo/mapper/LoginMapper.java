package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository //将类或接口标识为持久层组件
public interface LoginMapper extends BaseMapper<User>  {
    // 查询用户名
    @Select("select * from user where user_name=#{user_name}")
    User selectByName(String username);
}
