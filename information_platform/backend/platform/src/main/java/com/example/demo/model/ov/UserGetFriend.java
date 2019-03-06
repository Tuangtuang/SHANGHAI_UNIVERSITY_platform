package com.example.demo.model.ov;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserGetFriend {
    @JsonProperty("userid")
    String userid;
    @JsonProperty("usernickname")
    String usernickname;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsernickname() {
        return usernickname;
    }

    public void setUsernickname(String usernickname) {
        this.usernickname = usernickname;
    }
}
