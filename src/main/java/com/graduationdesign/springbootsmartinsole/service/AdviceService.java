package com.graduationdesign.springbootsmartinsole.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
            SportmanInfo sportmanInfo=new SportmanInfo();
            sportmanInfo=adviceMapper.findallById(adviceList.get(i).getSportman_id());
            advice_list.setExpert_id(adviceList.get(i).getExpert_id());
            advice_list.setSportman_id(adviceList.get(i).getSportman_id());
            advice_list.setSportman_name(sportmanInfo.getSportman_name());
            advice_list.setProfile_picture(sportmanInfo.getProfile_picture());
            adviceLists.add(advice_list);
        }
        return adviceLists;
    }

    public List<Advice> selectAll() {
        return adviceMapper.selectall();
    }

    public void modify(Advice advice) {
        adviceMapper.modify(advice);
    }

    public void delete(Advice advice) {
        adviceMapper.delete(advice);
    }

    public PageInfo<Advice> selectPage(Advice advice,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Advice> list = adviceMapper.select(advice,pageNum,pageSize);
        return PageInfo.of(list);
    }

    public List<BindExpert> get_list(ExpertInfo expertInfo) {
        List<BindExpert> bindExpert=bindExpertMapper.searchListByexpert_id(expertInfo);
        return bindExpert;
    }
}
