package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.BindExpert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BindExpertMapper {
    void bind(BindExpert bindExpert);

    void cancel(BindExpert bindExpert);
}
