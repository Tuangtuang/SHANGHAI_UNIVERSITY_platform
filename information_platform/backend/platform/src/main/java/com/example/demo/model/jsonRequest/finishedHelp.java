package com.example.demo.model.jsonRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//  37获取已完成 70
@Data
public class finishedHelp {
    @JsonProperty("missionid")
    String missionId;

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    @JsonProperty("id")
    String Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @JsonProperty("nickname")
    String Nickname;

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
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
}
