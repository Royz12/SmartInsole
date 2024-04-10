package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportAnalysis;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.entity.data;
import com.graduationdesign.springbootsmartinsole.mapper.SportAnalysisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportAnalysisService {
    @Autowired
    private SportAnalysisMapper sportAnalysisMapper;

//    public SportAnalysis getleftavg(SportmanInfo sportmanInfo) {
//        return sportAnalysisMapper.getleftavg(sportmanInfo);
//    }
//
//    public SportAnalysis getrightavg(SportmanInfo sportmanInfo) {
//        return sportAnalysisMapper.getrightavg(sportmanInfo);
//    }
//
//    public SportAnalysis getrightdir(SportmanInfo sportmanInfo) {
//        return sportAnalysisMapper.getrightdir(sportmanInfo);
//    }
//
//    public SportAnalysis getrightleft(SportmanInfo sportmanInfo) {
//        return sportAnalysisMapper.getleftdir(sportmanInfo);
//    }

    public SportAnalysis addRecord(SportmanInfo sportmanInfo) {
        SportAnalysis sportAnalysis =new SportAnalysis();
        SportAnalysis sportAnalysis_left=new SportAnalysis();
        SportAnalysis sportAnalysis_right=new SportAnalysis();
        SportAnalysis sportAnalysis_null=new SportAnalysis();

        sportAnalysis.setSportman_id(sportmanInfo.getSportman_id());
        sportAnalysis.setSportman_name(sportmanInfo.getSportman_name());
        sportAnalysis.setLeft_average(sportAnalysisMapper.getleftavg(sportmanInfo));
        sportAnalysis.setRight_average(sportAnalysisMapper.getrightavg(sportmanInfo));
        sportAnalysis.setLeft_result(sportAnalysisMapper.getleftdir(sportmanInfo));
        sportAnalysis.setRight_result(sportAnalysisMapper.getrightdir(sportmanInfo));

        //获取左右脚四个鞋垫区域压力(总共八个)
        sportAnalysis_left=sportAnalysisMapper.getleft_little_avg(sportmanInfo);
        sportAnalysis_right=sportAnalysisMapper.getright_little_avg(sportmanInfo);

        sportAnalysis.setLeft_result_1(sportAnalysis_left.getLeft_result_1());
        sportAnalysis.setLeft_result_2(sportAnalysis_left.getLeft_result_2());
        sportAnalysis.setLeft_result_3(sportAnalysis_left.getLeft_result_3());
        sportAnalysis.setLeft_result_4(sportAnalysis_left.getLeft_result_4());

        sportAnalysis.setRight_result_1(sportAnalysis_right.getRight_result_1());
        sportAnalysis.setRight_result_2(sportAnalysis_right.getRight_result_2());
        sportAnalysis.setRight_result_3(sportAnalysis_right.getRight_result_3());
        sportAnalysis.setRight_result_4(sportAnalysis_right.getRight_result_4());

        sportAnalysis_null=sportAnalysisMapper.getrecord(sportmanInfo);
        if(sportAnalysis_null.getSportman_id()!=0){
            sportAnalysisMapper.updateRecord(sportAnalysis);
        }else {
            sportAnalysisMapper.addRecord(sportAnalysis);
        }
        return sportAnalysis;
    }

    public List<data> echarts_data(ExpertInfo expertInfo) {
        List<Integer> record_idlist=sportAnalysisMapper.search_record_idList(expertInfo);
        return null;
    }
}
