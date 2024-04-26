package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExpertInfoMapper {
    void insert(ExpertInfo expertInfo);

    ExpertInfo FindByPass(String phonenumber);

    void update(ExpertInfo expertInfo);

    void modifyPass(ExpertInfo expertInfo);

    List<ExpertInfo> selectAll();

    List<ExpertInfo> search(ExpertInfo expertInfo);

    List<ExpertInfo> searchById(ExpertInfo expertInfo);

    ExpertInfo searchByid(ExpertInfo expertInfo);

    void delete(ExpertInfo expertInfo);

    List<ExpertInfo> select(@Param("expertInfo") ExpertInfo expertInfo, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);}
