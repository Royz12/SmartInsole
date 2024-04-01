package com.graduationdesign.springbootsmartinsole.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SportmanInfoDto {
    private int sportman_id;
    private String password;
    private String sportman_name;
    private String phonenumber;
    private double height;
    private double weight;
    private String selfintro;
    private int expert_id;
    private String left_id;
    private String right_id;
    private String profile_picture;
    private int age;
}
