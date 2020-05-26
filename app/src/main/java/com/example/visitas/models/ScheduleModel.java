package com.example.visitas.models;

import android.content.Context;

public class ScheduleModel {

    int id;
    String company;
    String description;
    String date;
    String image;

    public ScheduleModel(int id, String company, String description) {
        this.id = id;
        this.company = company;
        this.description = description;
    }

    public ScheduleModel(int id, String company, String description, String date) {
        this.id = id;
        this.company = company;
        this.description = description;
        this.date = date;
    }

    public ScheduleModel(int id, String company, String description, String date, String image) {
        this.id = id;
        this.company = company;
        this.description = description;
        this.date = date;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}