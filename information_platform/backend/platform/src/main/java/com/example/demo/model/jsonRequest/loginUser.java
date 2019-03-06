package com.example.demo.model.jsonRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
//  登陆接口
@Data
public class loginUser {
    @JsonProperty("userId")
    String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("userPwd")
    String userPwd;

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
