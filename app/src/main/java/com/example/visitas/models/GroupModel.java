package com.example.visitas.models;

public class GroupModel {

    int id;
    String group;
    String schedule;
    String image;

    public GroupModel(String group, String schedule, String image) {
        this.group = group;
        this.schedule = schedule;
        this.image = image;
    }

    public GroupModel(int id, String group, String schedule, String image) {
        this.id = id;
        this.group = group;
        this.schedule = schedule;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}