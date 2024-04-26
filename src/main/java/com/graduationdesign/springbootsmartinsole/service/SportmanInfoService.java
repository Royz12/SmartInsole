package com.graduationdesign.springbootsmartinsole.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.controller.dto.SportmanInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.mapper.SportmanInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SportmanInfoService {
    @Autowired
    private SportmanInfoMapper sportmanInfoMapper;
    public Result insert(SportmanInfo sportmanInfo) {
        SportmanInfo s=sportmanInfoMapper.FindByPass(sportmanInfo.getPhonenumber());
        if (s==null){
            sportmanInfoMapper.insert(sportmanInfo);
            return Result.success(sportmanInfo);
        }else {
            return Result.error("用户已存在");
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

    public Result modifyPass(SportmanInfo sportmanInfo) {
        SportmanInfo s=sportmanInfoMapper.FindByPass(sportmanInfo.getPhonenumber());
        if(s!=null){
            if(Objects.equals(sportmanInfo.getPassword(), s.getPassword())) {
                return Result.error("不能与原密码相同");
            }else {
                sportmanInfoMapper.modifyPass(sportmanInfo);
                return Result.success("修改成功");
            }
        } else{
            return Result.error("该用户不存在");
        }
    }

    public void delete(SportmanInfo sportmanInfo) {
        sportmanInfoMapper.delete(sportmanInfo);
    }

    public List<SportmanInfo> list() {
        return sportmanInfoMapper.list();
    }

    public PageInfo<SportmanInfo> selectPage(SportmanInfo sportmanInfo, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SportmanInfo> list = sportmanInfoMapper.selectall(sportmanInfo,pageNum,pageSize);
        return PageInfo.of(list);
    }
}
