package com.example.demo.model.ov;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ForumDetail {
    @JsonProperty("postid")
    Integer postid;

    @JsonProperty("label")
    Integer label;
    @JsonProperty("title")
    String title;
    @JsonProperty("content")
    String content;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("author")
    String author;
    @JsonProperty("authornickname")
    String authornickname;
    @JsonProperty("date")
    String date;

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthornickname() {
        return authornickname;
    }

    public void setAuthornickname(String authornickname) {
        this.authornickname = authornickname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
