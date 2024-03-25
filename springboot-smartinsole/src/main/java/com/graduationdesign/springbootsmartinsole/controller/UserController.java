package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.User;
import com.graduationdesign.springbootsmartinsole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 新增用户信息
     */
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Result add( @RequestBody User user){
        userService.insertUser(user);
        return Result.success();
    }
}
