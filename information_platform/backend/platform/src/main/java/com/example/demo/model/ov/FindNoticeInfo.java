package com.example.demo.model.ov;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
//获取所有公告接口
@Data
public class FindNoticeInfo {
    @JsonProperty("id")
    String id;
    @JsonProperty("title")
    String title;
    @JsonProperty("content")
    String content;
    @JsonProperty("date")
    String Date;
    @JsonProperty("type")
    String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
