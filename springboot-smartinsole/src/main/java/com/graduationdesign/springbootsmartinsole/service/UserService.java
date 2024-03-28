package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.entity.User;
import com.graduationdesign.springbootsmartinsole.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void insertUser (User user){
        userMapper.insert(user);
    }

    public void login(User user) {
        userMapper.login(user);
    }
}
