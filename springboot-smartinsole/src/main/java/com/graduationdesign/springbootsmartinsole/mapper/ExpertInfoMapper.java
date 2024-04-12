package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpertInfoMapper {
    void insert(ExpertInfo expertInfo);

    ExpertInfo FindByPass(String phonenumber);

    void update(ExpertInfo expertInfo);

    void modifyPass(ExpertInfo expertInfo);

    List<ExpertInfo> selectAll();

    List<ExpertInfo> search(ExpertInfo expertInfo);

}
