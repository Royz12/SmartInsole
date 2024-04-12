package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.BindExpert;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.mapper.BindExpertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<BindExpert> search(BindExpert bindExpert) {
        return bindExpertMapper.search(bindExpert);
    }

    public void update_bind(BindExpert bindExpert) {
        bindExpertMapper.update_bind(bindExpert);
    }

    public void update_cancel(BindExpert bindExpert) {
        bindExpertMapper.update_cancel(bindExpert);
    }

    public List<ExpertInfo> search_history(BindExpert bindExpert) {
        return bindExpertMapper.search_history(bindExpert);
    }
}
