package com.graduationdesign.springbootsmartinsole.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BindExpert {
    private int record_id;
    private int sportman_id;
    private int expert_id;
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

    public int getExpert_id() {
        return expert_id;
    }

    public void setExpert_id(int expert_id) {
        this.expert_id = expert_id;
    }

    public int getBind() {
        return bind;
    }

    public void setBind(int bind) {
        this.bind = bind;
    }
}
