package com.example.swagger.controller;

import com.example.swagger.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YZY
 * @date 2020/5/10 - 22:30
 */
@Api("控制类")
@ApiOperation("控制类")
@RestController
public class Controller {

    @PostMapping("/hi")
    public String show(){
        return "hi";
    }
//    ApiOperation 为controller的方法加注释
    @ApiOperation("实体类")
    @GetMapping("/user")
    public User user(){
        return new User();
    }

    @PostMapping("/username")
    public User user(User user)
    {
        return user;
    }
}
