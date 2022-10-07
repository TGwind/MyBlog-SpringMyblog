package com.example.demo.controller;

import com.auth0.jwt.JWT;
import com.example.demo.entity.User;
import com.example.demo.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BaseController {

    @Autowired
    private LoginMapper loginMapper; //@Repository

    @Autowired
    private HttpServletRequest request;

}
