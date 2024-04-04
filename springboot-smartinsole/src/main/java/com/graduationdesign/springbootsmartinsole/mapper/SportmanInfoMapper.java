package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.controller.dto.SportmanInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SportmanInfoMapper {
    void insert(SportmanInfo sportmanInfo);

    SportmanInfo FindByPass(String phonenumber);
    void update(SportmanInfo sportmanInfo);

    void modifyPass(SportmanInfo sportmanInfo);
}
