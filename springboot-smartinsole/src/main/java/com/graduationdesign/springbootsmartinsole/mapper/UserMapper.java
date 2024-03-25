package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into `user` (user_name,password,phonenumber,role_type,profile_picture) values (#{user_name},#{password},#{phonenumber},#{role_type},#{profile_picture})")
    void insert(User user);
}
