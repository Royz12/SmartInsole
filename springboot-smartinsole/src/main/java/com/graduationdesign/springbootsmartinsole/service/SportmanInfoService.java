package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.controller.dto.SportmanInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.mapper.SportmanInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportmanInfoService {
    @Autowired
    private SportmanInfoMapper sportmanInfoMapper;
    public Result insert(SportmanInfo sportmanInfo) {
        SportmanInfo s = sportmanInfoMapper.FindByPh(sportmanInfo.getPhonenumber());
        if(s==null){
            sportmanInfoMapper.insert(sportmanInfo);
            return Result.success();
        }else {
            return Result.error("手机号已被注册");
        }
    }

    public Result login(SportmanInfoDto SportmanInfoDto) {
        SportmanInfo s=sportmanInfoMapper.FindByPass(SportmanInfoDto.getPhonenumber());
        if (s==null){
            return Result.error("用户不存在");
        }
        if(s.getPassword().equals(SportmanInfoDto.getPassword())){
            return Result.success(s);
        }else{
            return Result.error("登录失败");
        }
    }
    public void updateInfo(SportmanInfo sportmanInfo) {
        sportmanInfoMapper.update(sportmanInfo);
    }

    public void modifyPass(SportmanInfo sportmanInfo) {
        sportmanInfoMapper.modifyPass(sportmanInfo);
    }
}
