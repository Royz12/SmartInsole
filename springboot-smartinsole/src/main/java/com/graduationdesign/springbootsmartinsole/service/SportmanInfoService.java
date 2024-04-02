package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.controller.dto.SportmanInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.mapper.SportmanInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportmanInfoService {
    @Autowired
    private SportmanInfoMapper sportmanInfoMapper;
    public void insert(SportmanInfo sportmanInfo) {
        sportmanInfoMapper.insert(sportmanInfo);
    }

    public Result login(SportmanInfoDto SportmanInfoDto) {
        String s=sportmanInfoMapper.FindByPass(SportmanInfoDto.getPhonenumber());
        if(s.equals(SportmanInfoDto.getPassword())){
            return Result.success(SportmanInfoDto);
        }else{
            return Result.error("登录失败");
        }
    }
}
