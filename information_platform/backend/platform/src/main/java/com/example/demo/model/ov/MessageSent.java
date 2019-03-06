package com.example.demo.model.ov;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageSent {
    @JsonProperty("messageid")
    Integer messageid;
    @JsonProperty("title")
    String title;
    @JsonProperty("date")
    String date;
    @JsonProperty("receiverid")
    String receiverid;
    @JsonProperty("receivernickname")
    String receivernickname;

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid;
    }

    public String getReceivernickname() {
        return receivernickname;
    }

    public void setReceivernickname(String receivernickname) {
        this.receivernickname = receivernickname;
    }
}
