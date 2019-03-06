package com.example.demo.model.jsonRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ForumChangeCommentLike {
    @JsonProperty("userid")
    String userid;
    @JsonProperty("commentid")
    Integer commentid;
    @JsonProperty("likestatus")
    String likestatus;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getLikestatus() {
        return likestatus;
    }

    public void setLikestatus(String likestatus) {
        this.likestatus = likestatus;
    }
}
