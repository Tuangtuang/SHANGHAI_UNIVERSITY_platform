package com.example.demo.model.entity;

public class Tag_Users {
    private Integer id;

    private String user;

    private Integer tag;

    private Integer extent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public Integer getExtent() {
        return extent;
    }

    public void setExtent(Integer extent) {
        this.extent = extent;
    }
}