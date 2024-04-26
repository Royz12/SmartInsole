package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.common.Result;
import com.graduationdesign.springbootsmartinsole.entity.BindInsole;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.mapper.BindInsoleMapper;
import com.graduationdesign.springbootsmartinsole.mapper.SportmanInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BindInsoleService {

    @Autowired
    private BindInsoleMapper bindInsoleMapper;
    @Autowired
    private SportmanInfoMapper sportmanInfoMapper;
    public void bindRight(BindInsole bindInsole) {
        SportmanInfo sportmanInfo=new SportmanInfo();
        sportmanInfo.setLeft_id(bindInsole.getLeft_id());
        sportmanInfo.setRight_id(bindInsole.getRight_id());
        sportmanInfo.setSportman_id(bindInsole.getSportman_id());


        if(bindInsoleMapper.exist(bindInsole)!=null){
            bindInsoleMapper.update(bindInsole);
            sportmanInfoMapper.update(sportmanInfo);
        }else {
            bindInsoleMapper.bindRight(bindInsole);
            sportmanInfoMapper.update(sportmanInfo);
        }
    }

    public String nullRight(BindInsole bindInsole) {
        return bindInsoleMapper.nullRight(bindInsole);
    }

    public String nullLeft(BindInsole bindInsole) {
        return bindInsoleMapper.nullLeft(bindInsole);
    }

    public void bindLeft(BindInsole bindInsole) {
        System.out.println(bindInsole);
        SportmanInfo sportmanInfo=new SportmanInfo();
        sportmanInfo.setLeft_id(bindInsole.getLeft_id());
        sportmanInfo.setRight_id(bindInsole.getRight_id());
        sportmanInfo.setSportman_id(bindInsole.getSportman_id());


        if(bindInsoleMapper.exist(bindInsole)!=null){
            bindInsoleMapper.update(bindInsole);
            sportmanInfoMapper.update(sportmanInfo);
        }else {
            bindInsoleMapper.bindLeft(bindInsole);
            sportmanInfoMapper.update(sportmanInfo);
        }
    }

    public void cancelIn_left(BindInsole bindInsole) {
        SportmanInfo sportmanInfo=new SportmanInfo();
        sportmanInfo.setSportman_id(bindInsole.getSportman_id());
        sportmanInfo.setLeft_id("");
        sportmanInfoMapper.update(sportmanInfo);
        bindInsoleMapper.cancel_left(bindInsole);
    }

    public void cancelIn_right(BindInsole bindInsole) {
        SportmanInfo sportmanInfo=new SportmanInfo();
        sportmanInfo.setSportman_id(bindInsole.getSportman_id());
        sportmanInfo.setRight_id("");
        sportmanInfoMapper.update(sportmanInfo);
        bindInsoleMapper.cancel_right(bindInsole);
    }
}
