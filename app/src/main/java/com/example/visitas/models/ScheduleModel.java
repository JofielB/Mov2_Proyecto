package com.example.visitas.models;

import android.content.Context;

public class ScheduleModel {

    String company;
    String description;
    String image;

    public ScheduleModel(String company, String description, String image) {
        this.company = company;
        this.description = description;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}