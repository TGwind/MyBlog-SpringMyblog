package com.example.demo.mapper;

import com.example.demo.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //将类或接口标识为持久层组件
public interface ArticleMapper extends BaseMapper<Article>  {
    @Select("select * from article where uid =#{uid}")
    List<Article> showByUid(Long uid);

}
