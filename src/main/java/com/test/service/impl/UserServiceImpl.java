package com.test.service.impl;

import com.test.mapper.UserMapper;
import com.test.model.User;
import com.test.service.IUserService;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
import com.test.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public JsonResponseBody login(User user) {
        User u = userMapper.login(user);
        if(null==u){
            //账号不存在
            return new JsonResponseBody(JsonResponseStatus.NULLACCOUNT.getCode(),JsonResponseStatus.NULLACCOUNT.getMsg());
        }else{
            MD5 md=new MD5();
            if(md.getMD5ofStr(user.getUpwd()).equals(u.getUpwd())){
                return new JsonResponseBody(u);
            }else{
                //密码不正确
                return new JsonResponseBody(JsonResponseStatus.PWDERROR.getCode(),JsonResponseStatus.PWDERROR.getMsg());
            }
        }
    }

    @Override
    public JsonResponseBody insertSelective(User user) {
        /*
         * 1.检测账号是否存在
         * 2.密码加密
         * 3.jdbc
         */

        User u = userMapper.login(user);
        if(null!=u){
            //账号已存在
            return new JsonResponseBody(JsonResponseStatus.ACCOUNTEXISTS.getCode(),JsonResponseStatus.ACCOUNTEXISTS.getMsg());
        }else{
            MD5 md=new MD5();
            //给密码加密处理
            String password=md.getMD5ofStr(user.getUpwd());
            user.setUpwd(password);
            int n = userMapper.insertSelective(user);
            if(n>0){
                return new JsonResponseBody();
            }else{
                return new JsonResponseBody(JsonResponseStatus.ERROR.getCode(),JsonResponseStatus.ERROR.getMsg());
            }
        }
    }
}
