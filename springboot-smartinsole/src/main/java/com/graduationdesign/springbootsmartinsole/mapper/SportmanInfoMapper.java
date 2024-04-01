package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SportmanInfoMapper {
    void insert(SportmanInfo sportmanInfo);

    String FindByPass(String phonenumber);
}
