package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.BindExpert;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BindExpertMapper {
    void bind(BindExpert bindExpert);

    void cancel(BindExpert bindExpert);

    List<BindExpert> search(BindExpert bindExpert);

    void update_bind(BindExpert bindExpert);

    void update_cancel(BindExpert bindExpert);

    List<BindExpert> searchListByexpert_id(ExpertInfo expertInfo);

    List<ExpertInfo> search_history(BindExpert bindExpert);

    int searchExpert(SportmanInfo sportmanInfo);

    BindExpert ifnull(BindExpert bindExpert);

    void update(BindExpert bindExpert);
}
