package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.Advice;
import com.graduationdesign.springbootsmartinsole.entity.ExpertInfo;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdviceMapper {
    void insert(Advice advice);

    List<Advice> show_advice(Advice advice);

    List<Advice> show_all(Advice advice);

    String findByid(int sportman_id);

    SportmanInfo findallById(int sportman_id);

    List<Advice> selectall();

    void modify(Advice advice);

    void delete(Advice advice);

    List<Advice> select( Integer pageNum, Integer pageSize);
}
