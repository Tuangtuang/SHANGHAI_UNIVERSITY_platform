package com.example.demo.model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Alarm {
    private Integer id;

    private String alarmingUser;

    private String alarmedUser;

    private Integer alarmType;

    private Timestamp time;

    private String reason;

    private Integer viewType;

    private Integer commendId;

    private Integer viewId;

    private Integer taskId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlarmingUser() {
        return alarmingUser;
    }

    public void setAlarmingUser(String alarmingUser) {
        this.alarmingUser = alarmingUser == null ? null : alarmingUser.trim();
    }

    public String getAlarmedUser() {
        return alarmedUser;
    }

    public void setAlarmedUser(String alarmedUser) {
        this.alarmedUser = alarmedUser == null ? null : alarmedUser.trim();
    }

    public Integer getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Integer getViewType() {
        return viewType;
    }

    public void setViewType(Integer viewType) {
        this.viewType = viewType;
    }

    public Integer getCommendId() {
        return commendId;
    }

    public void setCommendId(Integer commendId) {
        this.commendId = commendId;
    }

    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}