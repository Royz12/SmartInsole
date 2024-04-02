package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.Advice;
import com.graduationdesign.springbootsmartinsole.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.DuplicateFormatFlagsException;

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
        @GetMapping("/show")
        public Result show(@RequestBody Advice advice){
            String s=adviceService.show(advice);
            return Result.success(s);
        }

}
