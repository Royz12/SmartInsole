package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.entity.BindInsole;
import com.graduationdesign.springbootsmartinsole.mapper.BindInsoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BindInsoleService {
    @Autowired
    private BindInsoleMapper bindInsoleMapper;
    public void bindIn(BindInsole bindInsole) {
        bindInsoleMapper.bind(bindInsole);
    }

    public void cancelIn(BindInsole bindInsole) {
        bindInsoleMapper.cancel(bindInsole);
    }
}
