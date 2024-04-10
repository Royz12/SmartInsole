package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.controller.dto.SportmanInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.*;
import com.graduationdesign.springbootsmartinsole.mapper.BindExpertMapper;
import com.graduationdesign.springbootsmartinsole.mapper.ExpertInfoMapper;
import com.graduationdesign.springbootsmartinsole.mapper.SportAnalysisMapper;
import com.graduationdesign.springbootsmartinsole.mapper.SportmanInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportAnalysisService {
    @Autowired
    private SportAnalysisMapper sportAnalysisMapper;
    @Autowired
    private SportmanInfoMapper sportmanInfoMapper;
    @Autowired
    private BindExpertMapper bindExpertMapper;

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

    public void addRecord(ExpertInfo expertInfo) {
        List<BindExpert> bindExpertList=new ArrayList<>();
        bindExpertList= bindExpertMapper.searchListByexpert_id(expertInfo);
        for (int i=0;i<bindExpertList.size();i++){
            BindExpert bindExpert=bindExpertList.get(i);

            SportmanInfo dto=new SportmanInfo();
            dto.setSportman_id(bindExpert.getSportman_id());
            SportmanInfo sportmanInfo=sportmanInfoMapper.searchById(dto);

            SportAnalysis sportAnalysis =new SportAnalysis();
            SportAnalysis sportAnalysis_left;
            SportAnalysis sportAnalysis_right;
            SportAnalysis sportAnalysis_null;

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
        }

    }

    public List<Data> echarts_data(ExpertInfo expertInfo) {
        List<Data> dataList=new ArrayList<>();
        List<BindExpert> record_bindexpert_idlist=sportAnalysisMapper.search_record_idList(expertInfo);
        for(int i=0;i<record_bindexpert_idlist.size();i++){
            double[] valueList =new double[2];
            Sole_data sole_data=new Sole_data();
            Sole_data sole_data1=new Sole_data();
            double[] value=new double[4];
            double[] value1=new double[4];
            List<Sole_data> valueList1=new ArrayList<>();
            Data result=new Data();
            BindExpert bindExpert;
            SportmanInfo sportmanInfo=new SportmanInfo();
            SportAnalysis sportAnalysis;

            bindExpert=record_bindexpert_idlist.get(i);
            sportmanInfo.setSportman_id(bindExpert.getSportman_id());
            SportmanInfo sportmanInfo1=sportmanInfoMapper.searchById(sportmanInfo);

            sportAnalysis=sportAnalysisMapper.getrecord(sportmanInfo);

            valueList[0]=sportAnalysis.getLeft_average();
            valueList[1]=sportAnalysis.getRight_average();

            sole_data.setName("左脚");
            value[0]=sportAnalysis.getLeft_result_1();
            value[1]=sportAnalysis.getLeft_result_2();
            value[2]=sportAnalysis.getLeft_result_3();
            value[3]=sportAnalysis.getLeft_result_4();
            sole_data.setValue(value);

            sole_data1.setName("右脚");
            value1[0]=sportAnalysis.getRight_result_1();
            value1[1]=sportAnalysis.getRight_result_2();
            value1[2]=sportAnalysis.getRight_result_3();
            value1[3]=sportAnalysis.getRight_result_4();
            sole_data1.setValue(value1);

            valueList1.add(sole_data);
            valueList1.add(sole_data1);

            result.setId(bindExpert.getRecord_id());
            result.setName(sportmanInfo1.getSportman_name());
            result.setSportman_id(bindExpert.getSportman_id());
            result.setValueList(valueList);
            result.setValueList1(valueList1);
            result.setHeight(sportmanInfo1.getHeight());
            result.setWeight(sportmanInfo1.getWeight());

            dataList.add(result);
        }
        return dataList;
    }

    public SportAnalysis searchRecord(SportmanInfo sportmanInfo) {
        SportAnalysis sportAnalysis;
        sportAnalysis=sportAnalysisMapper.getrecord(sportmanInfo);
        return sportAnalysis;
    }
}
