package com.huya.springvalidationtest.model;


import com.huya.springvalidationtest.validation.PhoneValidation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Author: licg
 * @Date: 2019/1/28
 * @Description：用户类
 */
public class User {
    @NotBlank(message = "用户名不能为空")
    @Size(min = 3, max = 10, message = "用户名长度需要在3到10个字符长度")
    private String name;


    @NotBlank
    @Size(min = 6, max = 11, message = "密码需要在6到11个字符长度")
    private String password;

    @NotBlank(message = "Email不能为空")
    @Email(message = "输入的邮件格式不规范")
    private String email;

    @NotBlank(message = "手机号不能为空")
    @PhoneValidation
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}