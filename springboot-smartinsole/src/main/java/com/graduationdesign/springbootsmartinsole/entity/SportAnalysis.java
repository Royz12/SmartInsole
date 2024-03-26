package com.graduationdesign.springbootsmartinsole.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SportAnalysis {
    private int analysis_id;
    private int sportman_id;
    private String sportman_name;
    private double left_average;
    private double right_average;
    private String left_result;
    private String right_result;

    public int getAnalysis_id() {
        return analysis_id;
    }

    public void setAnalysis_id(int analysis_id) {
        this.analysis_id = analysis_id;
    }

    public int getSportman_id() {
        return sportman_id;
    }

    public void setSportman_id(int sportman_id) {
        this.sportman_id = sportman_id;
    }

    public String getSportman_name() {
        return sportman_name;
    }

    public void setSportman_name(String sportman_name) {
        this.sportman_name = sportman_name;
    }

    public double getLeft_average() {
        return left_average;
    }

    public void setLeft_average(double left_average) {
        this.left_average = left_average;
    }

    public double getRight_average() {
        return right_average;
    }

    public void setRight_average(double right_average) {
        this.right_average = right_average;
    }

    public String getLeft_result() {
        return left_result;
    }

    public void setLeft_result(String left_result) {
        this.left_result = left_result;
    }

    public String getRight_result() {
        return right_result;
    }

    public void setRight_result(String right_result) {
        this.right_result = right_result;
    }
}
