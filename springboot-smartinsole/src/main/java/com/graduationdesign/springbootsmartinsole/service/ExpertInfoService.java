package com.graduationdesign.springbootsmartinsole.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.controller.dto.ExpertInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.mapper.ExpertInfoMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ExpertInfoService {
    @Autowired
    private ExpertInfoMapper expertInfoMapper;
    public Result insertExpert(ExpertInfo expertInfo){
        ExpertInfo s=expertInfoMapper.FindByPass(expertInfo.getPhonenumber());
        if (s==null){
            expertInfoMapper.insert(expertInfo);
            return Result.success(expertInfo);
        }else {
            return Result.error("用户已存在");
        }
    }

    public Result login(ExpertInfoDto expertInfoDto) {
        ExpertInfo s=expertInfoMapper.FindByPass(expertInfoDto.getPhonenumber());
        if (s==null){
            return Result.error("用户不存在");
        }
        if(s.getPassword().equals(expertInfoDto.getPassword())){
            return Result.success(s);
        }else{
            return Result.error("登录失败");
        }
    }

    public void updateInfo(ExpertInfo expertInfo) {
        expertInfoMapper.update(expertInfo);
    }

    public Result modifyPass(ExpertInfo expertInfo) {
        ExpertInfo s=expertInfoMapper.FindByPass(expertInfo.getPhonenumber());
        if(s!=null){
            if(Objects.equals(expertInfo.getPassword(), s.getPassword())) {
                return Result.error("不能与原密码相同");
            }else {
                expertInfoMapper.modifyPass(expertInfo);
                return Result.success("修改成功");
            }
        } else{
            return Result.error("该用户不存在");
        }
    }

    public List<ExpertInfo> selectAll() {
        return expertInfoMapper.selectAll();
    }

    public List<ExpertInfo> searchById(ExpertInfo expertInfo) {
        return expertInfoMapper.searchById(expertInfo);
    }

    public List<ExpertInfo> search(ExpertInfo expertInfo) {
        String name=expertInfo.getExpert_name();
        int time=expertInfo.getWorktime();
        if (Objects.equals(name, "") &&time==0){
            System.out.println(time+"    "+name);
            return expertInfoMapper.selectAll();
        }else {
            return expertInfoMapper.search(expertInfo);
        }

    }

    public void delete(ExpertInfo expertInfo) {
        expertInfoMapper.delete(expertInfo);
    }

    public PageInfo<ExpertInfo> selectPage(@Param("expertInfo") ExpertInfo expertInfo, Integer pageNum, Integer pageSize) {
            PageHelper.startPage(pageNum, pageSize);
            List<ExpertInfo> list = expertInfoMapper.select(expertInfo, pageNum, pageSize);
        return PageInfo.of(list);
    }
}
