package com.test.service;

import com.test.model.Articles;
import com.test.util.JsonResponseBody;
import com.test.util.PageBean;

import java.util.List;

public interface IArticlesService {

    List<Articles> queryByPage(Articles articles, PageBean pageBean);

    JsonResponseBody insertSelective(Articles record);

    JsonResponseBody updateByPrimaryKeySelective(Articles record);
    JsonResponseBody deleteByPrimaryKey(Integer id);

}
