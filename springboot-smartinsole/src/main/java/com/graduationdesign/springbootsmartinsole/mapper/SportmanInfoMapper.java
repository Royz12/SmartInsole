package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.controller.dto.SportmanInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SportmanInfoMapper {


    SportmanInfo searchById(SportmanInfo sportmanInfo);

    void insert(SportmanInfo sportmanInfo);

    SportmanInfo FindByPass(String phonenumber);
    void update(SportmanInfo sportmanInfo);

    void modifyPass(SportmanInfo sportmanInfo);

    void delete(SportmanInfo sportmanInfo);

    List<SportmanInfo> list();

    List<SportmanInfo> selectall(SportmanInfo sportmanInfo, Integer pageNum, Integer pageSize);
}
