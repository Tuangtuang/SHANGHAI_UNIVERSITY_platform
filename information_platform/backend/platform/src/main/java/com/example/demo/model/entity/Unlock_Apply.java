package com.example.demo.model.entity;

import java.sql.Timestamp;

public class Unlock_Apply {
    private Integer id;

    private String applyer;

    private Integer type;

    private String title;

    private String content;

    private Timestamp time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer == null ? null : applyer.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}