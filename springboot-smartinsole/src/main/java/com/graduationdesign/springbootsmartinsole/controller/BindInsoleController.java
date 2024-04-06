package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.BindInsole;
import com.graduationdesign.springbootsmartinsole.service.BindInsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DuplicateFormatFlagsException;

@RestController
@RequestMapping("/bindinsole")
public class BindInsoleController {
    @Autowired
    private BindInsoleService bindInsoleService;
    /**
     * 绑定鞋垫
     * @param bindInsole
     */
    @PostMapping("/bind")
    public Result bind(@RequestBody BindInsole bindInsole){
        try{
            bindInsoleService.bindIn(bindInsole);
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("数据库错误");
            }else{
                return Result.error("系统错误");
            }
        }
        return Result.success(bindInsole);
    }
    /**
     * 取消绑定鞋垫
     */
    @PostMapping("/cancel")
    public Result cancel(@RequestBody BindInsole bindInsole){
        try{
            bindInsoleService.cancelIn(bindInsole);
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("数据库错误");
            }else{
                return Result.error("系统错误");
            }
        }
        return Result.success(bindInsole);
    }
}
