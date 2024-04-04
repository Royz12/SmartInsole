package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.controller.dto.ExpertInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.service.ExpertInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.DuplicateFormatFlagsException;
import java.util.List;

@RestController
@RequestMapping("/expertinfo")
public class ExpertInfoController {
    /**
     * 新增专家信息
     */
    @Autowired
    private ExpertInfoService expertInfoService;

    @PostMapping("/add")
    public Result add(@RequestBody ExpertInfo expertInfo){
        try{
            expertInfoService.insertExpert(expertInfo);
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
     * 专家登录
     * @param expertInfoDto
     */
    @PostMapping("/login")
    public Result login(@RequestBody ExpertInfoDto expertInfoDto){
        String PhoneNumber=expertInfoDto.getPhonenumber();
        String Password=expertInfoDto.getPassword();
        if( StringUtils.isEmpty(PhoneNumber) || StringUtils.isEmpty(Password)){
            return Result.error("请输入手机号或密码");
        }else{
            return expertInfoService.login(expertInfoDto);
        }
    }
    /**
     * 专家信息修改
     * @param expertInfo
     */
    @PostMapping("/update")
    public Result update(@RequestBody ExpertInfo expertInfo){
        try{
            expertInfoService.updateInfo(expertInfo);
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("修改信息失败");
            }else{
                return Result.error("系统错误");
            }
        }
        return Result.success(expertInfo);
    }
    /**
     * 专家密码修改
     * @param expertInfo
     */
    @PostMapping("/modifypass")
    public Result modify(@RequestBody ExpertInfo expertInfo){
        try{
            expertInfoService.modifyPass(expertInfo);
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("修改密码失败");
            }else{
                return Result.error("系统错误");
            }
        }
        return Result.success("修改成功");
    }
    /**
     * 展现所有专家信息
     */
    @GetMapping("/search")
    public Result search(){
        List<ExpertInfo> expertList=expertInfoService.selectAll();
        return Result.success(expertList);
    }
}
