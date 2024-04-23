package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.BindInsole;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BindInsoleMapper {
    void bind(BindInsole bindInsole);

    void cancel(BindInsole bindInsole);

    BindInsole selectById(SportmanInfo sportmanInfo);
}
