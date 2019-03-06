package com.example.demo.model.jsonRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class banUserByManager {
    @JsonProperty("manageid")
    String manageId;
    @JsonProperty("id")
    String id;
    @JsonProperty("forbid_type")
    String banType;
    @JsonProperty("forbid_reason")
    String banReason;
    @JsonProperty("forbid_date")
    String banEndDate;
    @JsonProperty("alarm_id")
    String alarmId;

    public String getManageId() {
        return manageId;
    }

    public void setManageId(String manageId) {
        this.manageId = manageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBanEndDate() {
        return banEndDate;
    }

    public void setBanEndDate(String banEndDate) {
        this.banEndDate = banEndDate;
    }
}
