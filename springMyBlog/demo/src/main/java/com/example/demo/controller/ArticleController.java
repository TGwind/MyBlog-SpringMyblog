package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.Article;
import com.example.demo.mapper.ArticleMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController //定义返回的是json数据的Controller
@RequestMapping("/article") //定义一个路由
public class ArticleController extends BaseController {
    @Resource
    private ArticleMapper articleMapper;

    @GetMapping("/getArticle/{uid}")
    public Result<?> showArticle(@PathVariable Long uid) {
        List<Article> articleList = articleMapper.showByUid(uid);
        return Result.success(articleList);
    }

    @GetMapping("/content/{id}")
    public Result<?> showContent(@PathVariable Long id) {
        Article article = articleMapper.selectById(id);
        return Result.success(article);
    }

    @PostMapping
    public Result<?> save(@RequestBody Article article) {//把json对象转化为java对象
        articleMapper.insert(article);
        return Result.success(article);
    }

    @GetMapping("/{rString}")
    public Result<?> searchArticle(@PathVariable String rString) {
        //条件封装
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(true, "title", rString);
        List<Article> articleList = articleMapper.selectList(queryWrapper);
        return Result.success(articleList);
    }
    @DeleteMapping("/{id}")
    public Result<?>  deleteById(@PathVariable Long id){
        return Result.success(articleMapper.deleteById(id));
    }

}
