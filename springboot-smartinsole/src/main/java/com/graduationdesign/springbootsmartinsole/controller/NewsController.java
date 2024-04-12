package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.News;
import com.graduationdesign.springbootsmartinsole.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    /**
     * 新增新闻
     */
    @Autowired
    private NewsService newsService;

    @PostMapping("/add")
    public Result add(@RequestBody News news){
        newsService.insertNews(news);
        return Result.success();
    }
    /**
     * 展现新闻
     */
    @PostMapping("/show")
    public Result show(@RequestBody ExpertInfo expertInfo){
        List<News> newsList = newsService.selectAll(expertInfo);
        return Result.success(newsList);
    }
}
