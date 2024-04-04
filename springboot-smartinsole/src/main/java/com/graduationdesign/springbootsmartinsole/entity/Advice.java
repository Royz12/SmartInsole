package com.graduationdesign.springbootsmartinsole.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Advice {
    private int adviceid;
    private int sportman_id;
    private int expert_id;
    private String advice;
}
