package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.controller.dto.SportmanInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.service.SportmanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

    /**
     * 运动员登录
     * @param SportmanInfoDto
     */
    @PostMapping("/login")
    public Result login(@RequestBody SportmanInfoDto SportmanInfoDto){
        String PhoneNumber=SportmanInfoDto.getPhonenumber();
        String Password=SportmanInfoDto.getPassword();
        if( StringUtils.isEmpty(PhoneNumber) || StringUtils.isEmpty(Password)){
            return Result.error("请输入手机号或密码");
        }else{
            return sportmanInfoService.login(SportmanInfoDto);
        }
    }
}
