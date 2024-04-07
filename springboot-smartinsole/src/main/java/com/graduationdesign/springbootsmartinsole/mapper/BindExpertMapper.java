package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.BindExpert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BindExpertMapper {
    void bind(BindExpert bindExpert);

    void cancel(BindExpert bindExpert);

    List<BindExpert> search(BindExpert bindExpert);

    void update_bind(BindExpert bindExpert);

    void update_cancel(BindExpert bindExpert);
}
