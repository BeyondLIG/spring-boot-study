package com.huya.springvalidationtest.controller;

import com.huya.springvalidationtest.model.Result;
import com.huya.springvalidationtest.model.User;
import com.huya.springvalidationtest.tools.UtilTools;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: licg
 * @Date: 2019/1/28
 * @Description：
 */
@RestController
public class ValidationController {
    @PostMapping("/validation/user")
    public String validationUser(@Validated User user){
        return UtilTools.getJSONString(new Result(200, "validation user success"));
    }
}