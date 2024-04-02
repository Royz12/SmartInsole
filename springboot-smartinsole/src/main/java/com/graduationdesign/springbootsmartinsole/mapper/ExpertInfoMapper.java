package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExpertInfoMapper {
    void insert(ExpertInfo expertInfo);

    String FindByPass(String phonenumber);

    void update(ExpertInfo expertInfo);

    void modifyPass(ExpertInfo expertInfo);
}
