package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.entity.BindExpert;
import com.graduationdesign.springbootsmartinsole.mapper.BindExpertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BindExpertService {
    @Autowired
    private BindExpertMapper bindExpertMapper;
    public void bindEx(BindExpert bindExpert) {
        bindExpertMapper.bind(bindExpert);
    }

    public void cancelEx(BindExpert bindExpert) {
        bindExpertMapper.cancel(bindExpert);
    }
}
