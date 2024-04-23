package com.graduationdesign.springbootsmartinsole.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduationdesign.springbootsmartinsole.entity.*;
import com.graduationdesign.springbootsmartinsole.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;
    public void insertNews(News news){
        newsMapper.insert(news);
    }

    public List<News_Info> selectAll(ExpertInfo expertInfo) {
        List<News_Info> newsInfos=new ArrayList<>();
        List<News> newsList=newsMapper.selectAll(expertInfo);
        for (int i=0;i<newsList.size();i++){
            News_Info newsInfo=new News_Info();
            newsInfo.setNews(newsList.get(i).getNews());
            newsInfos.add(newsInfo);
        }
        return newsInfos;
    }

    public void modify(News news) {
        newsMapper.modify(news);
    }

    public void delete(News news) {
        newsMapper.delete(news);
    }

    public PageInfo<News> selectPage(News news, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<News> list = newsMapper.select(news,pageNum,pageSize);
        return PageInfo.of(list);
    }


    public List<News> list(ExpertInfo expertInfo) {
        return newsMapper.list();
    }
}
