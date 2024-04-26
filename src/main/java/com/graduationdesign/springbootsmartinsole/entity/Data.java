package com.graduationdesign.springbootsmartinsole.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    int id;
    String name;
    int sportman_id;
    List<Sole_data1> valueList=new ArrayList<>();
    String[] result=new String[5544];
    List<Sole_data> valueList1=new ArrayList<>();
    double height;
    double weight;
}
