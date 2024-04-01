package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.entity.User;
import com.graduationdesign.springbootsmartinsole.service.SportmanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DuplicateFormatFlagsException;

@RestController
@RequestMapping("/sportmaninfo")
public class SportmanInfoController {
    /**
     * 新增运动员用户信息
     */
    @Autowired
    private SportmanInfoService sportmanInfoService;

    @PostMapping("/add")
    public Result add(@RequestBody SportmanInfo sportmanInfo){
        try{
            sportmanInfoService.insert(sportmanInfo);
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
    public Result login(@RequestBody SportmanInfo sportman) {
        SportmanInfo sportmaninfo;
        try {
            sportmaninfo = sportmanInfoService.login(sportman);
        } catch (Exception e) {
            if (e instanceof DuplicateFormatFlagsException) {
                return Result.error("插入数据库错误");
            } else {
                return Result.error("系统错误");
            }
        }
        return Result.success(sportmaninfo);
    }
}
