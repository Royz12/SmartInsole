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
    @PostMapping("/bindright")
    public Result bindright(@RequestBody BindInsole bindInsole) {
        try {
            if (bindInsoleService.nullRight(bindInsole)==null){
                return Result.error("鞋垫id不存在");
            }
//            if (bindInsoleService.ifRight(bindInsole)!=null){
//                return Result.error("右脚鞋垫已被绑定");
//            }
            bindInsoleService.bindRight(bindInsole);
        } catch (Exception e) {
            if (e instanceof DuplicateFormatFlagsException) {
                return Result.error("数据库错误");
            } else {
                e.printStackTrace();
                return Result.error("系统错误");
            }
        }
        return Result.success(bindInsole);
    }

    @PostMapping("/bindleft")
    public Result bindleft(@RequestBody BindInsole bindInsole) {
        try {
            if (bindInsoleService.nullLeft(bindInsole)==null){
                return Result.error("鞋垫id不存在");
            }
//            if (bindInsoleService.ifLeft(bindInsole)!=null){
//                return Result.error("左脚鞋垫已被绑定");
//            }
            bindInsoleService.bindLeft(bindInsole);
        } catch (Exception e) {
            if (e instanceof DuplicateFormatFlagsException) {
                return Result.error("数据库错误");
            } else {
                e.printStackTrace();
                return Result.error("系统错误");
            }
        }
        return Result.success(bindInsole);
    }
    /**
     * 取消绑定鞋垫
     */
    @PostMapping("/cancel/left")
    public Result cancel_left(@RequestBody BindInsole bindInsole){
        try{
            bindInsoleService.cancelIn_left(bindInsole);
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("数据库错误");
            }else{
                e.printStackTrace();
                return Result.error("系统错误");
            }
        }
        return Result.success(bindInsole);
    }

    @PostMapping("/cancel/right")
    public Result cancel_right(@RequestBody BindInsole bindInsole){
        try{
            bindInsoleService.cancelIn_right(bindInsole);
        }catch (Exception e){
            if(e instanceof DuplicateFormatFlagsException){
                return Result.error("数据库错误");
            }else{
                e.printStackTrace();
                return Result.error("系统错误");
            }
        }
        return Result.success(bindInsole);
    }
}
