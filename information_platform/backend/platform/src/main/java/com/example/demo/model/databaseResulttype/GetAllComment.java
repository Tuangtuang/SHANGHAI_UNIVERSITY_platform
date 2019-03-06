package com.example.demo.model.databaseResulttype;

import java.sql.Timestamp;

public class GetAllComment {
    private Integer id;
    private Integer view_id;
    private String user_id;
    private String content;
    private Timestamp time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getView_id() {
        return view_id;
    }

    public void setView_id(Integer view_id) {
        this.view_id = view_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
