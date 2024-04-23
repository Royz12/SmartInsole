package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.AdminInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminInfoMapper {
    AdminInfo FindByPhonenumber(String phonenumber);

    void insert(AdminInfo adminInfo);

    void update(AdminInfo adminInfo);

    void modifyPass(AdminInfo adminInfo);
}
