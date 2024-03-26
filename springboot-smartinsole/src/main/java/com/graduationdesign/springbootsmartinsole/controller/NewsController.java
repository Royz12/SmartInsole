package com.graduationdesign.springbootsmartinsole.controller;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.News;
import com.graduationdesign.springbootsmartinsole.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
