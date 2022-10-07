package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.Skill;
import com.example.demo.mapper.SkillMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController //定义返回的是json数据的Controller
@RequestMapping("/skill") //定义一个路由
public class SkillController extends BaseController {

    @Resource
    SkillMapper skillMapper;

    @GetMapping("/getSkill/{uid}") //获取项目
    public Result<?> showById(@PathVariable Long uid) {
        List<Skill> skillsList = skillMapper.selectByUid(uid);
        return Result.success(skillsList);
    }


    @PostMapping
    public Result<?> saveProject(@RequestBody Skill skill) {
        skillMapper.insert(skill);
        return Result.success();
    }

    @GetMapping("/{rString}")
    public Result<?> searchSkill(@PathVariable String rString) {
        //条件封装
        QueryWrapper<Skill> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(true, "skill", rString);
        List<Skill> skillList = skillMapper.selectList(queryWrapper);
        return Result.success(skillList);
    }

    @DeleteMapping("/delete/{id}")
    public Result<?> deleteById(@PathVariable Long id) {
        return Result.success(skillMapper.deleteById(id));
    }

    @PostMapping("/update")
    public Result<?> update(@RequestBody Skill skill){//把json对象转化为java对象
        skillMapper.updateById(skill);
        return  Result.success();
    }
}
