package com.example.demo.model.entity;

public class Ban_Reasons {
    private Integer id;

    private String bannedId;

    private Integer alarmId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBannedId() {
        return bannedId;
    }

    public void setBannedId(String bannedId) {
        this.bannedId = bannedId == null ? null : bannedId.trim();
    }

    public Integer getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Integer alarmId) {
        this.alarmId = alarmId;
    }
}