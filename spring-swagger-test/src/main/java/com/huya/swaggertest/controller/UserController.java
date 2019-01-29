package com.huya.swaggertest.controller;

import com.huya.swaggertest.model.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * @User: licg
 * @Date: 2019/1/17
 */


@RestController
@Api(value = "user", description = "用户操作", produces = "application/json")
public class UserController {

    @ApiOperation(value = "获取用户列表", notes = "")
    @GetMapping("/lists")
    public String userLists(){
        return "users";
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    @ApiResponses({
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 500, message = "服务器错误")
    })
    @PostMapping("/create")
    public String createUser(@RequestBody User user){
        return "user";
    }

    @ApiOperation(value = "更新用户信息", notes = "根据id，和user更新指定的user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "long"),
            @ApiImplicitParam(name = "user", value = "用户user", required = true, dataType = "User")
    })
    @PutMapping("/update/{id}")
    public String updateUserById(@PathVariable("id")long id, @RequestBody User user){
        return "user";
    }
}