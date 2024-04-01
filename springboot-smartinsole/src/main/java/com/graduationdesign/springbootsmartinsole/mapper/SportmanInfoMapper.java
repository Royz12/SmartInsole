package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SportmanInfoMapper {
    void insert(SportmanInfo sportmanInfo);

    SportmanInfo login(SportmanInfo sportman);
}
