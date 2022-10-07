package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.mapper.RegisterMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController //定义返回的是json数据的Controller
@RequestMapping("/register") //定义一个路由
public class RegisterController extends BaseController {
    @Resource
    RegisterMapper registerMapper;
    @PostMapping
    public Result<?> save(@RequestBody User user){//把json对象转化为java对象
        registerMapper.insert(user);
        return  Result.success(user);
    }
}
