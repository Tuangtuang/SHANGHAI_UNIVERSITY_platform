package com.example.demo.model.ov;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IfManage {
    @JsonProperty("ifmanage")
    Boolean ifmanage;

    public Boolean getIfmanage() {
        return ifmanage;
    }

    public void setIfmanage(Boolean ifmanage) {
        this.ifmanage = ifmanage;
    }
}
