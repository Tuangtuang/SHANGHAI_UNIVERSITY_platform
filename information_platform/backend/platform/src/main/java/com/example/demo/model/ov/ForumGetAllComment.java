package com.example.demo.model.ov;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ForumGetAllComment {
    @JsonProperty("commentid")
    Integer commentid;
    @JsonProperty("author")
    String author;
    @JsonProperty("authornickname")
    String authornickname;
    @JsonProperty("content")
    String content;
    @JsonProperty("date")
    String date;
    @JsonProperty("likenum")
    Integer likenum;
    @JsonProperty("likestatus")
    String likestatus;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
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

    public String getLikestatus() {
        return likestatus;
    }

    public void setLikestatus(String likestatus) {
        this.likestatus = likestatus;
    }
}
