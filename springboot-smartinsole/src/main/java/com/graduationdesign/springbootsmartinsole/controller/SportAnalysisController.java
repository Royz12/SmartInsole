package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportAnalysis;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.entity.data;
import com.graduationdesign.springbootsmartinsole.service.SportAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sportanalysis")
public class SportAnalysisController {
    @Autowired
    private SportAnalysisService sportAnalysisService;

//    /**
//     * 左脚平均压力测量
//     * @param sportmanInfo
//     */
//    @PostMapping("/leftavg")
//    public Result leftavg(@RequestBody SportmanInfo sportmanInfo){
//        double s =  sportAnalysisService.getleftavg(sportmanInfo);
//        return Result.success(s);
//    }
//
//    /**
//     * 右脚平均压力测量
//     * @param sportmanInfo
//     */
//    @PostMapping("/rightavg")
//    public Result rightavg(@RequestBody SportmanInfo sportmanInfo){
//        double s =  sportAnalysisService.getrightavg(sportmanInfo);
//        return Result.success(s);
//    }
//    /**
//     * 左脚鞋垫压力偏向
//     * @param sportmanInfo
//     * @output -1 -2 -3 -4
//     */
//    @PostMapping("/leftdir")
//    public Result leftdir(@RequestBody SportmanInfo sportmanInfo){
//        int dir = sportAnalysisService.getrightleft(sportmanInfo);
//        return Result.success(dir);
//    }
//    /**
//     * 右脚鞋垫压力偏向
//     * @param sportmanInfo -1 -2 -3 -4
//     * @output -1 -2 -3 -4
//     */
//    @PostMapping("/rightdir")
//    public Result rightdir(@RequestBody SportmanInfo sportmanInfo){
//        int dir = sportAnalysisService.getrightdir(sportmanInfo);
//        return Result.success(dir);
//    }
    /**
     * 记录分析数据
     */
    @PostMapping("/addrecord")
    public Result addRecord(@RequestBody SportmanInfo sportmanInfo){
        SportAnalysis sportAnalysis;
        sportAnalysis=sportAnalysisService.addRecord(sportmanInfo);
        return Result.success(sportAnalysis);
    }

    /**
     * 返回数据可视化所需数据
     */
    @PostMapping("/echarts_data")
    public Result echarts_data(@RequestBody ExpertInfo expertInfo){
        List<data> result=sportAnalysisService.echarts_data(expertInfo);
        return Result.success(result);
    }
}
