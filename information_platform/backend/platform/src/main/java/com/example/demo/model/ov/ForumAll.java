package com.example.demo.model.ov;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ForumAll {
    @JsonProperty("postid")
    Integer postid;
    @JsonProperty("label")
    Integer label;
    @JsonProperty("title")
    String title;
    @JsonProperty("author")
    String author;
    @JsonProperty("authornickname")
    String authornickname;
    @JsonProperty("date")
    String date;
    @JsonProperty("commentnum")
    Integer commentnum;
    @JsonProperty("likenum")
    Integer likenum;

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

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }
}
