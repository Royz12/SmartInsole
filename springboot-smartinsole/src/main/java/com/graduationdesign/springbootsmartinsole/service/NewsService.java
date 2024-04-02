package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.entity.News;
import com.graduationdesign.springbootsmartinsole.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;
    public void insertNews(News news){
        newsMapper.insert(news);
    }

    public List<News> selectAll() {
        return newsMapper.selectAll();
    }
}
