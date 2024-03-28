package com.graduationdesign.springbootsmartinsole.service;

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
}
