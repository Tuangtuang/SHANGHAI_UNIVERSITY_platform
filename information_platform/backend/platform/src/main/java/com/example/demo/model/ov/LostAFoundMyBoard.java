package com.example.demo.model.ov;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LostAFoundMyBoard {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("title")
    String title;
    @JsonProperty("content")
    String content;
    @JsonProperty("connect")
    String connect;
    @JsonProperty("date")
    String date;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
