package com.test.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

/**
 * @author: KangQi
 * @createTime: 2022/12/13:17:04
 * @name: IndexController
 * @description:
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("toLogin")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/doLogin")
    public String dologin(HttpSession session, String username, String password){
        Subject subject = SecurityUtils.getSubject ();
        UsernamePasswordToken token = new UsernamePasswordToken (username,password);
        try {
            subject.login (token);
        } catch (AuthenticationException e) {
            System.out.println ("身份验证失败");
            session.setAttribute ("message","身份验证失败");
            return "login";
        }
        session.setAttribute ("username",username);
        return "main";
    }
}
