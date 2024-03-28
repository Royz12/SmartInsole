package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.User;
import com.graduationdesign.springbootsmartinsole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.DuplicateFormatFlagsException;

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
        try{
            userService.insertUser(user);
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("插入数据库错误");
            }else{
                return Result.error("系统错误");
            }
        }
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        userService.login(user);
        return Result.success();
    }
}
