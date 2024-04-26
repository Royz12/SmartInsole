package com.graduationdesign.springbootsmartinsole.controller;

import com.github.pagehelper.PageInfo;
import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.*;
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
        List<News_Info> newsList = newsService.selectAll(expertInfo);
        return Result.success(newsList);
    }
    /**
     * 管理端展现新闻
     */
    @PostMapping("/list")
    public Result list(@RequestBody ExpertInfo expertInfo){
        List<News> newsList = newsService.list();
        return Result.success(newsList);
    }
    /**管理端修改新闻
     *
     * @param news
     * @return
     */
    @PostMapping("/modify")
    public Result modify_news(@RequestBody News news){
        try {
            newsService.modify(news);
            return Result.success("修改成功");
        }catch (Exception e){
            return Result.error("修改失败");
        }
    }

    /**
     * 管理端删除新闻
     * @param news
     * @return
     */
    @DeleteMapping("/delete")
    public Result delete_news(@RequestBody News news){
        try {
            newsService.delete(news);
            return Result.success("删除成功");
        }catch (Exception e){
            return Result.error("删除失败");
        }
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(News news,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<News> page = newsService.selectPage(news, pageNum, pageSize);
        return Result.success(page);
    }
}
