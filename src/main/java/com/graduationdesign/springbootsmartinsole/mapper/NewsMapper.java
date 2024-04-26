package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.News;
import com.graduationdesign.springbootsmartinsole.entity.News_Info;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {
    void insert(News news);

    List<News> selectAll(ExpertInfo expertInfo);

    void modify(News news);

    void delete(News news);

    List<News> list();

    List<News> select(News news, Integer pageNum, Integer pageSize);
}
