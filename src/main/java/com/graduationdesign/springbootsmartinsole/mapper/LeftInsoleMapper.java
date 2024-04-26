package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.BindInsole;
import com.graduationdesign.springbootsmartinsole.entity.LeftInsole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeftInsoleMapper {
    LeftInsole selectById(BindInsole bindInsole);
}
