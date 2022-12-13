package com.test.service.impl;

import com.test.mapper.ArticlesMapper;
import com.test.model.Articles;
import com.test.service.IArticlesService;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
import com.test.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticlesServiceImpl implements IArticlesService {
    @Autowired
    private ArticlesMapper articlesMapper;
    @Override
    public List<Articles> queryByPage(Articles articles, PageBean pageBean) {
        List<Articles> articlesList = articlesMapper.queryByPage(articles);
        return articlesList;
    }

    @Override
    public JsonResponseBody insertSelective(Articles record) {
        int n = articlesMapper.insertSelective(record);
        if(n<=0){
            return new JsonResponseBody(JsonResponseStatus.SAVEERROR.getCode(),JsonResponseStatus.SAVEERROR.getMsg());
        }
        return new JsonResponseBody();
    }

    @Override
    public JsonResponseBody updateByPrimaryKeySelective(Articles record) {
        int n = articlesMapper.updateByPrimaryKeySelective(record);
        if(n<=0){
            return new JsonResponseBody(JsonResponseStatus.UPDATEERROR.getCode(),JsonResponseStatus.UPDATEERROR.getMsg());
        }
        return new JsonResponseBody();
    }

    @Override
    public JsonResponseBody deleteByPrimaryKey(Integer id) {
        int n = articlesMapper.deleteByPrimaryKey(id);
        if(n<=0){
            return new JsonResponseBody(JsonResponseStatus.DELERROR.getCode(),JsonResponseStatus.DELERROR.getMsg());
        }
        return new JsonResponseBody();
    }
}
