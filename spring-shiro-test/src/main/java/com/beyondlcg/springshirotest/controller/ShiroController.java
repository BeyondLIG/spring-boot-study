package com.beyondlcg.springshirotest.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: licg
 * @Date: 2019/1/25
 * @Description：Shiro权限管理：https://mrbird.cc/tags/Shiro/
 */
@Controller
public class ShiroController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password")String password,
                        @RequestParam("rememberMe")boolean rememberMe){
        // 密码MD5加密，此处省略
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return "success";
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("user", "Jack");
        return "index";
    }

}