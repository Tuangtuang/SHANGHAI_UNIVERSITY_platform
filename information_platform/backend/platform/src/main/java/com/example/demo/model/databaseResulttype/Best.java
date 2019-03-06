package com.example.demo.model.databaseResulttype;

import java.sql.Timestamp;

public class Best {
    private Integer id;

    private String title;

    private Timestamp time;

    private String puller;

    private Integer tags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getPuller() {
        return puller;
    }

    public void setPuller(String puller) {
        this.puller = puller;
    }

    public Integer getTags() {
        return tags;
    }

    public void setTags(Integer tags) {
        this.tags = tags;
    }
}
