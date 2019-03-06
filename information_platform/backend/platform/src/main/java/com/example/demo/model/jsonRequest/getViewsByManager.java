package com.example.demo.model.jsonRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class getViewsByManager {
    @JsonProperty("id")
    String id;
    @JsonProperty("title")
    String title;
    @JsonProperty("type")
    String type;
    @JsonProperty("addresser")
    String addresser;
    @JsonProperty("date")
    String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddresser() {
        return addresser;
    }

    public void setAddresser(String addresser) {
        this.addresser = addresser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
