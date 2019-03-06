package com.example.demo.model.jsonRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//获取互助系统已发布任务的接口
@Data
public class claimedAndUnfinishedHelp {
    @JsonProperty("missionid")
    String missionId;

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    @JsonProperty("acceptid")
    String acceptId;

    public String getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(String acceptId) {
        this.acceptId = acceptId;
    }

    @JsonProperty("acceptnickname")
    String acceptNickname;

    public String getAcceptNickname() {
        return acceptNickname;
    }

    public void setAcceptNickname(String acceptNickname) {
        this.acceptNickname = acceptNickname;
    }

    @JsonProperty("content")
    String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("startdate")
    String startDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("enddate")
    String endDate;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("phone")
    String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("missionstatus")
    String missionStatus;

    public String getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }
}
