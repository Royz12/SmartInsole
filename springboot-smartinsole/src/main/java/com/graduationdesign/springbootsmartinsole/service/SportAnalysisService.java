package com.graduationdesign.springbootsmartinsole.service;

import com.graduationdesign.springbootsmartinsole.entity.SportAnalysis;
import com.graduationdesign.springbootsmartinsole.entity.SportmanInfo;
import com.graduationdesign.springbootsmartinsole.mapper.SportAnalysisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportAnalysisService {
    @Autowired
    private SportAnalysisMapper sportAnalysisMapper;

    public double getleftavg(SportmanInfo sportmanInfo) {
        return sportAnalysisMapper.getleftavg(sportmanInfo);
    }

    public double getrightavg(SportmanInfo sportmanInfo) {
        return sportAnalysisMapper.getrightavg(sportmanInfo);
    }

    public int getrightdir(SportmanInfo sportmanInfo) {
        return sportAnalysisMapper.getrightdir(sportmanInfo);
    }

    public int getrightleft(SportmanInfo sportmanInfo) {
        return sportAnalysisMapper.getleftdir(sportmanInfo);
    }

    public void addRecord(SportAnalysis sportAnalysis) {
        sportAnalysisMapper.addRecord(sportAnalysis);
    }
}
