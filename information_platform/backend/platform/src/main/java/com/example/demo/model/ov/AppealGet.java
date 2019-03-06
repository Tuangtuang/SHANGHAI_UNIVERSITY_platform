package com.example.demo.model.ov;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AppealGet {
    @JsonProperty("type")
    Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
