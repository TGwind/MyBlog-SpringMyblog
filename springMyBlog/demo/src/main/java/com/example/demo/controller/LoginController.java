package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.mapper.LoginMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController //定义返回的是json数据的Controller
@RequestMapping("/login") //定义一个路由
public class LoginController extends BaseController {
    @Resource
    LoginMapper loginMapper;

    @PostMapping()
    public Result<?> login(@RequestBody User loginParam) {
        User loginPassword = loginMapper.selectByName(loginParam.getUserName());  //根据用户名查询用户的密码
        if (loginPassword == null) {
            return Result.error("0", "用户为空");
        } else if (loginParam.getUserPassword().equals(loginPassword.getUserPassword())) {
            return Result.success(loginPassword);
        }
        return Result.error("0", "密码错误");
    }

}
