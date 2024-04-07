package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SportAnalysisMapper {

    double getleftavg(SportmanInfo sportmanInfo);

    double getrightavg(SportmanInfo sportmanInfo);

    int getrightdir(SportmanInfo sportmanInfo);

    int getleftdir(SportmanInfo sportmanInfo);
}
