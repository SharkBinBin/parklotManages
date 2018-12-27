package com.example.demo.pojo;

public class Garageinfo {
    private Integer giid;

    private Integer gid;

    private String cost;

    public Integer getGiid() {
        return giid;
    }

    public void setGiid(Integer giid) {
        this.giid = giid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost == null ? null : cost.trim();
    }
}