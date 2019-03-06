package com.example.demo.model.entity;

public class Friends {
    private Integer id;

    private String usera;

    private String userb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsera() {
        return usera;
    }

    public void setUsera(String usera) {
        this.usera = usera == null ? null : usera.trim();
    }

    public String getUserb() {
        return userb;
    }

    public void setUserb(String userb) {
        this.userb = userb == null ? null : userb.trim();
    }
}