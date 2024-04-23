package com.graduationdesign.springbootsmartinsole.controller;

import com.github.pagehelper.PageInfo;
import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.controller.dto.ExpertInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
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
        String Password = expertInfo.getPassword();
        String PhNum = expertInfo.getPhonenumber();
        try{
            if(StringUtils.isEmpty(Password) || StringUtils.isEmpty(PhNum)){
                return Result.error("密码或手机号为空");
//            }else if(Password.length()<8){
//                return Result.error("密码长度小于8位");
//            }else if(PhNum.length()!=11){
//                return Result.error("手机号长度应为11位");
            }else{
                return expertInfoService.insertExpert(expertInfo);
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
     * @param expertInfoDto
     */
    @PostMapping("/login")
    public Result login(@RequestBody ExpertInfoDto expertInfoDto){
        String PhoneNumber=expertInfoDto.getPhonenumber();
        String Password=expertInfoDto.getPassword();
        if( StringUtils.isEmpty(PhoneNumber) || StringUtils.isEmpty(Password)){
            return Result.error("请输入手机号或密码");
//        }else if(PhoneNumber.length()!=11){
//            return Result.error("手机号应为11位");
//        }else if(Password.length()<8){
//            return Result.error("密码位数至少为8位");
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
        String Password = expertInfo.getPassword();
        String PhNum = expertInfo.getPhonenumber();
        try{
            if(StringUtils.isEmpty(Password) || StringUtils.isEmpty(PhNum)){
                return Result.error("密码或手机号为空");
            }else if(Password.length()<8){
                return Result.error("密码长度小于8位");
            }else if(PhNum.length()!=11){
                return Result.error("手机号长度应为11位");
            }else{
                return expertInfoService.modifyPass(expertInfo);
            }
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("修改密码失败");
            }else{
                return Result.error("系统错误");
            }
        }
    }
    /**
     * 展现所有专家信息
     */
    @GetMapping("/list")
    public Result list(){
        List<ExpertInfo> expertList=expertInfoService.selectAll();
        return Result.success(expertList);
    }

    @PostMapping("/search")
    public Result search(@RequestBody ExpertInfo expertInfo){
        List<ExpertInfo> expertList=expertInfoService.search(expertInfo);
        return Result.success(expertList);
    }

    @PostMapping("/searchById")
    public Result searchById(@RequestBody ExpertInfo expertInfo){
        List<ExpertInfo> expertInfoList=expertInfoService.searchById(expertInfo);
        return Result.success(expertInfoList);
    }

    /**
     * 管理端删除专家信息
     * @param expertInfo
     * @return
     */
    @DeleteMapping("/deleteexpert")
    public Result delete(@RequestBody ExpertInfo expertInfo){
        try {
            System.out.println(expertInfo.getExpert_id());
            expertInfoService.delete(expertInfo);
            return Result.success("删除成功");
        }catch (Exception e){
            return Result.error("删除失败");
        }
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam ExpertInfo expertInfo,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<ExpertInfo> page = expertInfoService.selectPage(expertInfo, pageNum, pageSize);
        System.out.println("3");
        return Result.success(page);
    }
}
