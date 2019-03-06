package com.example.demo.model.jsonRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//  管理员获取全部用户信息
@Data
public class getUserInfoByManager {
    @JsonProperty("id")
    String userId;
    @JsonProperty("name")
    String userName;
    @JsonProperty("status")
    String status;
    @JsonProperty("forbid_type")
    String banType;
    @JsonProperty("forbid_reason")
    String banReason;
    @JsonProperty("forbid_date")
    String date;
    @JsonProperty("password")
    String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBanType() {
        return banType;
    }

    public void setBanType(String banType) {
        this.banType = banType;
    }

    public String getBanReason() {
        return banReason;
    }

    public void setBanReason(String banReason) {
        this.banReason = banReason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
