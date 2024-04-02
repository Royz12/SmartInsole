package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.BindExpert;
import com.graduationdesign.springbootsmartinsole.service.BindExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DuplicateFormatFlagsException;

@RestController
@RequestMapping("/bindexpert")
public class BindExpertController {
    @Autowired
    private BindExpertService bindExpertService;
    /**
     * 绑定专家
     * @param bindExpert
     */
    @PostMapping("/bind")
    public Result bind(@RequestBody BindExpert bindExpert){
        try{
            bindExpertService.bindEx(bindExpert);
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("数据库错误");
            }else{
                return Result.error("系统错误");
            }
        }
        return Result.success(bindExpert);
    }
    /**
     * 取消绑定专家
     * @param bindExpert
     */
    @PostMapping("/cancel")
    public Result cancel(@RequestBody BindExpert bindExpert){
        try{
            bindExpertService.cancelEx(bindExpert);
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("数据库错误");
            }else{
                return Result.error("系统错误");
            }
        }
        return Result.success(bindExpert);
    }
}
