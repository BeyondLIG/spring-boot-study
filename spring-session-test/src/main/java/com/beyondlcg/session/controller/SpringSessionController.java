package com.beyondlcg.session.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: licg
 * @Date: 2019/1/29
 * @Description：
 */
@RestController
public class SpringSessionController {
    @GetMapping("/test/spring/session")
    public String springSession(HttpServletRequest request, HttpSession session){
        String value = (String) session.getAttribute("key");
        if (StringUtils.isEmpty(value)){
            System.out.println("不存在session，设置 key = value");
            session.setAttribute("key", "value");
        }else {
            System.out.println("存在session，key = "+ value);
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " ： " + cookie.getValue());
            }
        }
        return "Spring Session";
    }
}