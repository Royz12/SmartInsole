package com.graduationdesign.springbootsmartinsole.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BindExpert {
    private int record_id;
    private int sportman_id;
    private String sportman_name;
    private int expert_id;
    private String expert__name;
    private int bind;

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
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

    public int getExpert_id() {
        return expert_id;
    }

    public void setExpert_id(int expert_id) {
        this.expert_id = expert_id;
    }

    public String getExpert__name() {
        return expert__name;
    }

    public void setExpert__name(String expert__name) {
        this.expert__name = expert__name;
    }

    public int getBind() {
        return bind;
    }

    public void setBind(int bind) {
        this.bind = bind;
    }
}
