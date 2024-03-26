package com.graduationdesign.springbootsmartinsole.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BindInsole {
    private int record_id;
    private int sportman_id;
    private int left_id;
    private int right_id;
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

    public int getLeft_id() {
        return left_id;
    }

    public void setLeft_id(int left_id) {
        this.left_id = left_id;
    }

    public int getRight_id() {
        return right_id;
    }

    public void setRight_id(int right_id) {
        this.right_id = right_id;
    }

    public int getBind() {
        return bind;
    }

    public void setBind(int bind) {
        this.bind = bind;
    }
}
