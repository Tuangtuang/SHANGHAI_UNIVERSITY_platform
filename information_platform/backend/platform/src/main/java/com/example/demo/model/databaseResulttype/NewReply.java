package com.example.demo.model.databaseResulttype;

import java.sql.Timestamp;

public class NewReply {
    private Integer id;

    private String title;

    private Timestamp time;

    private String puller;

    private Integer tags;

    private Timestamp commentTime;

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

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }
}
