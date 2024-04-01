package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.entity.Advice;
import com.graduationdesign.springbootsmartinsole.mapper.AdviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdviceService {
    @Autowired
    private AdviceMapper adviceMapper;
    public void insertAdvice(Advice advice) {
        adviceMapper.insert(advice);
    }
}
