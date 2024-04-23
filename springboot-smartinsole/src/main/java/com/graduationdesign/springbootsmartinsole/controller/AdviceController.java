package com.graduationdesign.springbootsmartinsole.controller;

import com.github.pagehelper.PageInfo;
import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.*;
import com.graduationdesign.springbootsmartinsole.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.DuplicateFormatFlagsException;
import java.util.List;

@RestController
@RequestMapping("/advice")
public class AdviceController {
        /**
         * 新增建议
         */
        @Autowired
        private AdviceService adviceService;

        @PostMapping("/add")
        public Result add(@RequestBody Advice advice){
            try{
                adviceService.insertAdvice(advice);
            }catch (Exception e){
                if(e instanceof DuplicateFormatFlagsException){
                    return Result.error("插入数据库错误");
                }else {
                    return Result.error("系统错误");
                }
            }
            return Result.success();
        }

        /**
         * 管理端展示建议列表
         * @return
         */
        @PostMapping("/list")
        public Result list(){
            List<Advice> advice=adviceService.selectAll();
            return Result.success(advice);
        }

        /**管理端修改建议
         *
         * @param advice
         * @return
         */
        @PostMapping("/modify")
        public Result modify_advice(@RequestBody Advice advice){
            try {
                adviceService.modify(advice);
                return Result.success("修改成功");
            }catch (Exception e){
                return Result.error("修改失败");
            }
        }

        /**
         * 管理端删除建议
         * @param advice
         * @return
         */
        @DeleteMapping("/delete")
        public Result delete_advice(@RequestBody Advice advice){
            try {
                adviceService.delete(advice);
                return Result.success("删除成功");
            }catch (Exception e){
                return Result.error("删除失败");
            }
        }


        /**
         * 分页查询
         */
        @GetMapping("/selectPage")
        public Result selectPage(
                                 @RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize) {
            PageInfo<Advice> page = null;
            try {
                page = adviceService.selectPage( pageNum, pageSize);
            } catch (Exception e) {
                System.out.println(e);
            }
            return Result.success(page);
        }

        /**
         * 查看专家的建议
         */
        @PostMapping("/show_advice")
        public Result show_advice(@RequestBody Advice advice){
            List<Advice_Info> adviceInfolist=adviceService.show_advice(advice);
            return Result.success(adviceInfolist);
        }

        @PostMapping("/show_info")
        public Result show_info(@RequestBody ExpertInfo expertInfo){
            List<Advice_List> adviceLists=adviceService.show_list(expertInfo);
            return Result.success(adviceLists);
        }
}
