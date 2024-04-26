package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.controller.dto.SportmanInfoDto;
import com.graduationdesign.springbootsmartinsole.entity.AdminInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.mapper.AdminInfoMapper;
import com.graduationdesign.springbootsmartinsole.mapper.SportmanInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminInfoService {
    @Autowired
    private AdminInfoMapper adminInfoMapper;
    public Result insert(AdminInfo adminInfo) {
        AdminInfo s=adminInfoMapper.FindByPhonenumber(adminInfo.getPhonenumber());
        if (s==null){
            adminInfoMapper.insert(adminInfo);
            return Result.success(adminInfo);
        }else {
            return Result.error("用户已存在");
        }
    }

    public Result login(AdminInfo adminInfo) {
        AdminInfo s=adminInfoMapper.FindByPhonenumber(adminInfo.getPhonenumber());
        if (s==null){
            return Result.error("用户不存在");
        }
        if(s.getPassword().equals(adminInfo.getPassword())){
            return Result.success(s);
        }else{
            return Result.error("登录失败");
        }
    }
    public void updateInfo(AdminInfo adminInfo) {
        adminInfoMapper.update(adminInfo);
    }

    public Result modifyPass(AdminInfo adminInfo) {
        AdminInfo s=adminInfoMapper.FindByPhonenumber(adminInfo.getPhonenumber());
        if(s!=null){
            if(Objects.equals(adminInfo.getPassword(), s.getPassword())) {
                return Result.error("不能与原密码相同");
            }else {
                adminInfoMapper.modifyPass(adminInfo);
                return Result.success("修改成功");
            }
        } else{
            return Result.error("该用户不存在");
        }
    }
}
