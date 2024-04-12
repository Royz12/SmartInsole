package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.Advice;
import com.graduationdesign.springbootsmartinsole.entity.Advice_List;
import com.graduationdesign.springbootsmartinsole.entity.Advice_Info;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.DuplicateFormatFlagsException;
import java.util.List;

@RestController
@RequestMapping("/advice")
public class AdviceController {
        /**
         * 新增建议
         */
        @Autowired
        private AdviceService adviceService;

        @PostMapping("/add")
        public Result add(@RequestBody Advice advice){
            try{
                adviceService.insertAdvice(advice);
            }catch (Exception e){
                if(e instanceof DuplicateFormatFlagsException){
                    return Result.error("插入数据库错误");
                }else {
                    return Result.error("系统错误");
                }
            }
            return Result.success();
        }
        /**
         * 查看专家的建议
         */
        @PostMapping("/show_advice")
        public Result show_advice(@RequestBody Advice advice){
            List<Advice_Info> adviceInfolist=adviceService.show_advice(advice);
            return Result.success(adviceInfolist);
        }

        @PostMapping("/show_info")
        public Result show_info(@RequestBody ExpertInfo expertInfo){
            List<Advice_List> adviceLists=adviceService.show_list(expertInfo);
            return Result.success(adviceLists);
        }
}
