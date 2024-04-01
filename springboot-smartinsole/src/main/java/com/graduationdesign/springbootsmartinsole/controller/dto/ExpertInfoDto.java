package com.graduationdesign.springbootsmartinsole.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExpertInfoDto {
    private int expert_id;
    private String password;
    private String expert_name;
    private String phonenumber;
    private double height;
    private double weight;
    private int worktime;
    private String selfintro;
    private String profile_picture;
}
