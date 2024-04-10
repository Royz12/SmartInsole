package com.graduationdesign.springbootsmartinsole.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class data {
    int id;
    String name;
    int sportman_id;
    int[] valueList =new int[2];
    sole_data valueList1;
    int height;
    int weight;
}
