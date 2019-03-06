package com.example.demo.model.entity;

import java.sql.Timestamp;

public class Notices {
    private Integer id;

    private String puller;

    private String title;

    private String content;

    private Integer type;

    private Timestamp time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuller() {
        return puller;
    }

    public void setPuller(String puller) {
        this.puller = puller == null ? null : puller.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}