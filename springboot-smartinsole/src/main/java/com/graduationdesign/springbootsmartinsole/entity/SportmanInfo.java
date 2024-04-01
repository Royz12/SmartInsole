package com.graduationdesign.springbootsmartinsole.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SportmanInfo {
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

    public int getSportman_id() {
        return sportman_id;
    }

    public void setSportman_id(int sportman_id) {
        this.sportman_id = sportman_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSportman_name() {
        return sportman_name;
    }

    public void setSportman_name(String sportman_name) {
        this.sportman_name = sportman_name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSelfintro() {
        return selfintro;
    }

    public void setSelfintro(String selfintro) {
        this.selfintro = selfintro;
    }

    public int getExpert_id() {
        return expert_id;
    }

    public void setExpert_id(int expert_id) {
        this.expert_id = expert_id;
    }

    public String getLeft_id() {
        return left_id;
    }

    public void setLeft_id(String left_id) {
        this.left_id = left_id;
    }

    public String getRight_id() {
        return right_id;
    }

    public void setRight_id(String right_id) {
        this.right_id = right_id;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }
}
