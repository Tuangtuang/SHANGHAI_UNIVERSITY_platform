package com.example.demo.model.jsonRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EditPwd {
    @JsonProperty("userID")
    String userId;
    @JsonProperty("userOldPwd")
    String userOldPwd;
    @JsonProperty("userNewPwd")
    String userNewPwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserOldPwd() {
        return userOldPwd;
    }

    public void setUserOldPwd(String userOldPwd) {
        this.userOldPwd = userOldPwd;
    }

    public String getUserNewPwd() {
        return userNewPwd;
    }

    public void setUserNewPwd(String userNewPwd) {
        this.userNewPwd = userNewPwd;
    }
}
