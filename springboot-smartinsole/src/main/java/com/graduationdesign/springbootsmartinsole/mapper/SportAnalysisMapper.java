package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.BindExpert;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportAnalysis;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SportAnalysisMapper {

    double getleftavg(SportmanInfo sportmanInfo);

    double getrightavg(SportmanInfo sportmanInfo);

    int getrightdir(SportmanInfo sportmanInfo);

    int getleftdir(SportmanInfo sportmanInfo);

    void addRecord(SportAnalysis sportAnalysis);



    SportAnalysis getleft_little_avg(SportmanInfo sportmanInfo);

    SportAnalysis getright_little_avg(SportmanInfo sportmanInfo);

    SportAnalysis getrecord(SportmanInfo sportmanInfo);

    List<BindExpert> search_record_idList(ExpertInfo expertInfo);
}
