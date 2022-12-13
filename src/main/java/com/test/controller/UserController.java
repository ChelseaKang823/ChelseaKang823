package com.test.controller;

import com.test.model.User;
import com.test.service.IUserService;
import com.test.util.JsonResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/login")
    public JsonResponseBody login(User user){

        return userService.login(user);
    }

    @RequestMapping("/register")
    public JsonResponseBody register(User user){
        return  userService.insertSelective(user);
    }

}
