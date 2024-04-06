package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.BindInsole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BindInsoleMapper {
    void bind(BindInsole bindInsole);

    void cancel(BindInsole bindInsole);
}
