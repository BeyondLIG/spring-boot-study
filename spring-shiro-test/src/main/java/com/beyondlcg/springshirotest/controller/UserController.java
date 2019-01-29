package com.beyondlcg.springshirotest.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: licg
 * @Date: 2019/1/25
 * @Description：Shiro权限管理：https://mrbird.cc/tags/Shiro/
 */
@Controller
@RequestMapping("/user")
public class UserController {

    // @RequiresPermissions：Shiro权限注解，表示当前Subject需要权限value=user:list
    @RequiresPermissions(value = "user:list")
    @GetMapping("/list")
    public String userList(Model model){
        model.addAttribute("value", "获取用户信息");
        return "user";
    }

    @RequiresPermissions(value = "user:add")
    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("value", "新增用户");
        return "user";
    }

    @RequiresPermissions(value = "user:delete")
    @GetMapping("/delete")
    public String deleteUser(Model model){
        model.addAttribute("value", "删除用户");
        return "user";
    }
}