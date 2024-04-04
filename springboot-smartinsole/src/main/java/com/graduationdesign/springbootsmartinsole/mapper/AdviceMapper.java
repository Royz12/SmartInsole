package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.Advice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdviceMapper {
    void insert(Advice advice);

    List<Advice> show(Advice advice);
}
