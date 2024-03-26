package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.service.ExpertInfoService;
import com.graduationdesign.springbootsmartinsole.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        expertInfoService.insertExpert(expertInfo);
        return Result.success();
    }
}
