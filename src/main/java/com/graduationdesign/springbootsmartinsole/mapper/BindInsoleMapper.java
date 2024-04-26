package com.graduationdesign.springbootsmartinsole.mapper;

import com.graduationdesign.springbootsmartinsole.entity.BindInsole;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BindInsoleMapper {
    void bind(BindInsole bindInsole);

    void cancel(BindInsole bindInsole);

    BindInsole selectById(SportmanInfo sportmanInfo);

    BindInsole selectByRightInsoleId(BindInsole bindInsole);

    BindInsole selectByLeftInsoleId(BindInsole bindInsole);

    String nullRight(BindInsole bindInsole);

    BindInsole exist(BindInsole bindInsole);

    void update(BindInsole bindInsole);

    void bindRight(BindInsole bindInsole);


    String nullLeft(BindInsole bindInsole);

    void bindLeft(BindInsole bindInsole);

    void cancel_left(BindInsole bindInsole);

    void cancel_right(BindInsole bindInsole);
}
