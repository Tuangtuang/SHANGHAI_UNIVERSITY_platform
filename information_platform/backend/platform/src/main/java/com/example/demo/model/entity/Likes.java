package com.example.demo.model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Likes {
    private Integer id;

    private Integer viewId;

    private String userId;

    private Timestamp time;

    private Integer type;

    private Integer commendId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCommendId() {
        return commendId;
    }

    public void setCommendId(Integer commendId) {
        this.commendId = commendId;
    }
}