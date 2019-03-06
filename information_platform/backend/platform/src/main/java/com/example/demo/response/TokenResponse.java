package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//  token返回接口
@Data
public class TokenResponse {
    @JsonProperty("identity")
    private Integer identity;

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }
    @JsonProperty("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    @JsonProperty("userNickname")
    private String userNickname;

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
    @JsonProperty("userId")
    private String userId;

    public String getId() {
        return userId;
    }

    public void setId(String id) {
        userId = id;
    }
}
