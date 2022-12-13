package com.test.controller;

import com.test.model.Articles;
import com.test.service.IArticlesService;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
import com.test.util.PageBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/articles")
@CrossOrigin
public class ArticlesController {
    @Resource
    private IArticlesService articlesService;

    @RequestMapping("/list")
    public JsonResponseBody query(Articles articles,PageBean pageBean){
        List<Articles> articlesList = articlesService.queryByPage(articles,pageBean);
        assert articlesList != null;
        if(articlesList.size() ==0){
            return new JsonResponseBody(JsonResponseStatus.ERROR.getCode(),JsonResponseStatus.ERROR.getMsg());
        }
        else{
            return new JsonResponseBody<>(articlesList, (long) pageBean.getTotal());
        }
    }

    @RequestMapping("/edit")
    public JsonResponseBody edit(Articles articles){
        JsonResponseBody jsonResponseBody;
        if(null==articles.getId()){
            jsonResponseBody = articlesService.insertSelective(articles);
        }else{
            jsonResponseBody=articlesService.updateByPrimaryKeySelective(articles);
        }
        return jsonResponseBody;
    }

    @RequestMapping("/del")
    public JsonResponseBody del(Integer id){
        return articlesService.deleteByPrimaryKey(id);

    }
}
