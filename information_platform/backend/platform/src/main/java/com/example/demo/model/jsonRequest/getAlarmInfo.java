package com.example.demo.model.jsonRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class getAlarmInfo {
    @JsonProperty("id")
    String id;
    @JsonProperty("reporter_id")
    String reporterId;
    @JsonProperty("bereported_id")
    String beReportedId;
    @JsonProperty("messageid")
    String messageId;
    @JsonProperty("date")
    String date;
    @JsonProperty("type")
    String type;
    @JsonProperty("reason")
    String reason;
    @JsonProperty("content")
    String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReporterId() {
        return reporterId;
    }

    public void setReporterId(String reporterId) {
        this.reporterId = reporterId;
    }

    public String getBeReportedId() {
        return beReportedId;
    }

    public void setBeReportedId(String beReportedId) {
        this.beReportedId = beReportedId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
