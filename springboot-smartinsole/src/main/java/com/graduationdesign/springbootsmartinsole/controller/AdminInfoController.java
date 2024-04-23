package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.controller.dto.SportmanInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.AdminInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.entity.User;
import com.graduationdesign.springbootsmartinsole.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DuplicateFormatFlagsException;

@RestController
@RequestMapping("admin")
public class AdminInfoController {
    @Autowired
    private AdminInfoService adminInfoService;

    /**
     * 专家注册
     * @param adminInfo
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody AdminInfo adminInfo){
        String Password = adminInfo.getPassword();
        String PhNum= adminInfo.getPhonenumber();
        try{
            if(StringUtils.isEmpty(Password) || StringUtils.isEmpty(PhNum)){
                return Result.error("密码或手机号为空");
//            }else if(Password.length()<8){
//                return Result.error("密码长度小于8位");
//            }else if(PhNum.length()!=11){
//                return Result.error("手机号长度应为11位");
            }else{
                return adminInfoService.insert(adminInfo);
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
     * 专家登录
     * @param
     */
    @PostMapping("/login")
    public Result login(@RequestBody AdminInfo adminInfo){
        String PhoneNumber=adminInfo.getPhonenumber();
        String Password=adminInfo.getPassword();
        if( StringUtils.isEmpty(PhoneNumber) || StringUtils.isEmpty(Password)){
            return Result.error("请输入手机号或密码");
//        }else if(PhoneNumber.length()!=11){
//            return Result.error("手机号应为11位");
//        }else if(Password.length()<8){
//            return Result.error("密码位数至少为8位");
        }else{
            return adminInfoService.login(adminInfo);
        }
    }
    /**
     * 用户信息修改
     * @param adminInfo
     */
    @PostMapping("/update")
    public Result update(@RequestBody AdminInfo adminInfo){
        try{
            adminInfoService.updateInfo(adminInfo);
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("修改信息失败");
            }else{
                e.printStackTrace();
                return Result.error("系统错误");
            }
        }
        return Result.success(adminInfo);
    }
    /**
     * 用户密码修改
     * @param adminInfo
     */
    @PostMapping("/modifypass")
    public Result modify(@RequestBody AdminInfo adminInfo){
        String Password = adminInfo.getPassword();
        String PhNum= adminInfo.getPhonenumber();
        try{
            if(StringUtils.isEmpty(Password) || StringUtils.isEmpty(PhNum)){
                return Result.error("密码或手机号为空");
            }else if(Password.length()<8){
                return Result.error("密码长度小于8位");
            }else if(PhNum.length()!=11){
                return Result.error("手机号长度应为11位");
            }else{
                return adminInfoService.modifyPass(adminInfo);
            }
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("修改密码失败");
            }else{
                return Result.error("系统错误");
            }
        }
    }
}
