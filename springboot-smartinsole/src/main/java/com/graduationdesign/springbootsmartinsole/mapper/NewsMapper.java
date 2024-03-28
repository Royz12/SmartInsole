package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.News;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper {
    void insert(News news);
}
