package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.controller.dto.SportmanInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.service.SportmanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
        String Password = sportmanInfo.getPassword();
        String PhNum= sportmanInfo.getPhonenumber();
        try{
            if(StringUtils.isEmpty(Password) || StringUtils.isEmpty(PhNum)){
                return Result.error("密码或手机号为空");
            }else if(Password.length()<8){
                return Result.error("密码长度小于8位");
            }else if(PhNum.length()!=11){
                return Result.error("手机号长度应为11位");
            }else{
                return sportmanInfoService.insert(sportmanInfo);
            }
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("插入数据库错误");
            }else{
                return Result.error("系统错误");
            }
        }
    }

    /**
     * 运动员登录-校验
     * @param SportmanInfoDto
     */
    @PostMapping("/login")
    public Result login(@RequestBody SportmanInfoDto SportmanInfoDto){
        String PhoneNumber=SportmanInfoDto.getPhonenumber();
        String Password=SportmanInfoDto.getPassword();
        if( StringUtils.isEmpty(PhoneNumber) || StringUtils.isEmpty(Password)){
            return Result.error("请输入手机号或密码");
        }else if(PhoneNumber.length()!=11){
            return Result.error("手机号应为11位");
        }else if(Password.length()<8){
            return Result.error("密码位数至少为8位");
        }else{
            return sportmanInfoService.login(SportmanInfoDto);
        }
    }
    /**
     * 用户信息修改
     * @param sportmanInfo
     */
    @PostMapping("/update")
    public Result update(@RequestBody SportmanInfo sportmanInfo){
        try{
            sportmanInfoService.updateInfo(sportmanInfo);
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("修改信息失败");
            }else{
                e.printStackTrace();
                return Result.error("系统错误");
            }
        }
        System.out.println(sportmanInfo);
        return Result.success(sportmanInfo);
    }

    /***
     * 用户密码修改-校验
     * @param sportmanInfo
     * @return
     */
    @PostMapping("/modifypass")
    public Result modify(@RequestBody SportmanInfo sportmanInfo){
        String Password = sportmanInfo.getPassword();
        String PhNum= sportmanInfo.getPhonenumber();
        try{
            if(StringUtils.isEmpty(Password) || StringUtils.isEmpty(PhNum)){
                return Result.error("密码或手机号为空");
            }else if(Password.length()<8){
                return Result.error("密码长度小于8位");
            }else if(PhNum.length()!=11){
                return Result.error("手机号长度应为11位");
            }else{
                sportmanInfoService.modifyPass(sportmanInfo);
            }
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("修改密码失败");
            }else{
                return Result.error("系统错误");
            }
        }
        return Result.success("修改成功");
    }
}
