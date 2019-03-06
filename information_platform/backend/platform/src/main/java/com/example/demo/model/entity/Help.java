package com.example.demo.model.entity;

import java.sql.Timestamp;

public class Help {
    private Integer id;

    private String puller;

    private String title;

    private String content;

    private Timestamp startTime;

    private Timestamp endTime;

    private Integer state;

    private String receiver;

    private String pusherPhone;

    private String receiverPhone;

    private String others;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuller() {
        return puller;
    }

    public void setPuller(String puller) {
        this.puller = puller == null ? null : puller.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getPusherPhone() {
        return pusherPhone;
    }

    public void setPusherPhone(String pusherPhone) {
        this.pusherPhone = pusherPhone == null ? null : pusherPhone.trim();
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
    }
}