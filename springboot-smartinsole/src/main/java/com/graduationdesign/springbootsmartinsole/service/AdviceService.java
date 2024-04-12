package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.entity.*;
import com.graduationdesign.springbootsmartinsole.mapper.AdviceMapper;
import com.graduationdesign.springbootsmartinsole.mapper.BindExpertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdviceService {
    @Autowired
    private AdviceMapper adviceMapper;
    @Autowired
    private BindExpertMapper bindExpertMapper;
    public void insertAdvice(Advice advice) {
        adviceMapper.insert(advice);
    }

    public List<Advice_Info> show_advice(Advice advice) {
        List<Advice_Info> adviceInfolist=new ArrayList<>();
        List<Advice> adviceList= adviceMapper.show_advice(advice);
        for (int i=0;i<adviceList.size();i++){
            Advice_Info adviceInfo=new Advice_Info();
            adviceInfo.setAdvice(adviceList.get(i).getAdvice());
            adviceInfolist.add(adviceInfo);
        }
        return adviceInfolist;
    }

    public List<Advice_List> show_list(ExpertInfo expertInfo) {
        List<BindExpert> adviceList=bindExpertMapper.searchListByexpert_id(expertInfo);
        List<Advice_List> adviceLists=new ArrayList<>();
        for (int i=0;i<adviceList.size();i++){
            Advice_List advice_list=new Advice_List();
            advice_list.setExpert_id(adviceList.get(i).getExpert_id());
            advice_list.setSportman_id(adviceList.get(i).getSportman_id());
            advice_list.setSportman_name(adviceMapper.findByid(adviceList.get(i).getSportman_id()));
            adviceLists.add(advice_list);
        }
        return adviceLists;
    }
}
