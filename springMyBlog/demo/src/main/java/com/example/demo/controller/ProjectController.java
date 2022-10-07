package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.Article;
import com.example.demo.entity.Project;
import com.example.demo.mapper.ProjectMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController //定义返回的是json数据的Controller
@RequestMapping("/project") //定义一个路由
public class ProjectController extends BaseController {

    @Resource
    ProjectMapper projectMapper;

    @GetMapping("/getProject/{uid}") //获取项目
    public Result<?> showById(@PathVariable Long uid) {
        List<Project> projectList = projectMapper.selectByUid(uid);
        return Result.success(projectList);
    }


    @PostMapping
    public Result<?> saveProject(@RequestBody Project project) {
        projectMapper.insert(project);
        return Result.success();
    }

    @GetMapping("/{rString}")
    public Result<?> searchProject(@PathVariable String rString) {
        //条件封装
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(true, "title", rString);
        List<Project> articleList = projectMapper.selectList(queryWrapper);
        return Result.success(articleList);
    }

    @DeleteMapping("/delete/{id}")
    public Result<?> deleteById(@PathVariable Long id) {
        return Result.success(projectMapper.deleteById(id));
    }

    @PostMapping("/update")
    public Result<?> update(@RequestBody Project project){//把json对象转化为java对象
        projectMapper.updateById(project);
        return  Result.success();
    }
}
