package com.example.demo.model.jsonRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
//  管理员添加公告
@Data
public class addNoticeJsonRequest {
    @JsonProperty("managerid")
    String managerId;
    @JsonProperty("title")
    String title;
    @JsonProperty("content")
    String content;
    @JsonProperty("type")
    String type;

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
