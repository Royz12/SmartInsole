package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.BindExpert;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.service.BindExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.DuplicateFormatFlagsException;
import java.util.List;

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
            bindExpertService.update_bind(bindExpert);
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
            bindExpertService.update_cancel(bindExpert);
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
     * 输出绑定对应专家的运动员id
     */
    @PostMapping("/search")
    public Result search(@RequestBody BindExpert bindExpert){
        List<BindExpert> list=bindExpertService.search(bindExpert);
        return Result.success(list);
    }
    /**
     * 输出用户历史绑定的专家id
     */
    @PostMapping("/search_history")
    public Result search_history(@RequestBody BindExpert bindExpert){
        List<ExpertInfo> list=bindExpertService.search_history(bindExpert);
        return Result.success(list);
    }
}
