package com.example.demo.model.jsonRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ForumCreatePost {
    @JsonProperty("userid")
    String userid;
    @JsonProperty("title")
    String title;
    @JsonProperty("content")
    String content;
    @JsonProperty("label")
    Integer label;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }
}
