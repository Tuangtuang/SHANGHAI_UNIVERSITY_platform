package com.example.demo.model.ov;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageReceive {
    @JsonProperty("messageid")
    Integer messageid;
    @JsonProperty("title")
    String title;
    @JsonProperty("date")
    String date;
    @JsonProperty("senderid")
    String senderid;
    @JsonProperty("sendernickname")
    String sendernickname;
    @JsonProperty("status")
    String status;

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

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getSendernickname() {
        return sendernickname;
    }

    public void setSendernickname(String sendernickname) {
        this.sendernickname = sendernickname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
