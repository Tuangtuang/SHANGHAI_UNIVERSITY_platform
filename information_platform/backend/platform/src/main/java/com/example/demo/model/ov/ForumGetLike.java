package com.example.demo.model.ov;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ForumGetLike {
    @JsonProperty("likestatus")
    String likestatus;

    public String getLikestatus() {
        return likestatus;
    }

    public void setLikestatus(String likestatus) {
        this.likestatus = likestatus;
    }
}
