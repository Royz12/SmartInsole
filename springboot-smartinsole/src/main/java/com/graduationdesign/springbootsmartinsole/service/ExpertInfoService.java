package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.controller.dto.ExpertInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.mapper.ExpertInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpertInfoService {
    @Autowired
    private ExpertInfoMapper expertInfoMapper;
    public void insertExpert(ExpertInfo expertInfo){
        expertInfoMapper.insert(expertInfo);
    }

    public Result login(ExpertInfoDto expertInfoDto) {
        String s=expertInfoMapper.FindByPass(expertInfoDto.getPhonenumber());
        if(s.equals(expertInfoDto.getPassword())){
            return Result.success("登录成功");
        }else{
            return Result.error("登录失败");
        }
    }
}
