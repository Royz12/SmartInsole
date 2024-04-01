package com.graduationdesign.springbootsmartinsole.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Advice {
    private int adviceid;
    private int sportman_id;
    private String sportman_name;
    private int expert_id;
    private String expert_name;
    private String advice;
}
