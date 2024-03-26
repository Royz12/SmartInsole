package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.entity.News;
import com.graduationdesign.springbootsmartinsole.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;
    public void insertNews(News news){
        newsMapper.insert(news);
    }

}
