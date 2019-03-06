package com.example.demo.model.ov;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserGetComment {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("postid")
    Integer postid;
    @JsonProperty("author")
    String author;
    @JsonProperty("authornickname")
    String authornickname;
    @JsonProperty("title")
    String title;
    @JsonProperty("content")
    String content;
    @JsonProperty("date")
    String date;
    @JsonProperty("likenum")
    Integer likenum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }
}
