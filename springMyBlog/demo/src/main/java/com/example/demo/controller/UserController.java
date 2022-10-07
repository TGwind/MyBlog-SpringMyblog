package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController //定义返回的是json数据的Controller
@RequestMapping("/user") //定义一个路由
public class UserController extends BaseController {

    @Resource
    UserMapper userMapper;

    @GetMapping("{uid}")
    public Result<?> getByUid(@PathVariable Long uid){
        return Result.success(userMapper.selectByUid(uid));
    }
    @PostMapping()
    public Result<?> login(@RequestBody User userParam) {
        User login = userMapper.selectByName(userParam.getUserName());  //根据用户名查询用户的密码
        if (login == null) {
            return Result.error("0", "mmm");
        } else if (userParam.getUserPassword().equals(login.getUserPassword())) {
            return Result.success(login);
        }
        return Result.error("0", "mmm");
    }
    @PutMapping("/update") //更新请求
    public Result<?> update(@RequestBody User userParam){
        userMapper.updateById(userParam);
        return Result.success();
    }

}
