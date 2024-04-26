package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.BindInsole;
import com.graduationdesign.springbootsmartinsole.entity.RightInsole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RightInsoleMapper {
    RightInsole selectById(BindInsole bindInsole);
}
