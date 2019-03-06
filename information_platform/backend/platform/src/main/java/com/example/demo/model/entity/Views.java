package com.example.demo.model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Views {
    private Integer id;

    private String title;

    private String content;

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
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        this.puller = puller == null ? null : puller.trim();
    }

    public Integer getTags() {
        return tags;
    }

    public void setTags(Integer tags) {
        this.tags = tags;
    }
}