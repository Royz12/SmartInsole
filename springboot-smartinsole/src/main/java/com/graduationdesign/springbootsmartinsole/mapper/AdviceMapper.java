package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.Advice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdviceMapper {
    void insert(Advice advice);

    String show(Advice advice);
}
