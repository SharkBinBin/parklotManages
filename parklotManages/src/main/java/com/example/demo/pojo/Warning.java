package com.example.demo.pojo;

import java.util.Date;

public class Warning {
    private Integer wid;

    private String wname;

    private String wcontent;

    private Date wrelease;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname == null ? null : wname.trim();
    }

    public String getWcontent() {
        return wcontent;
    }

    public void setWcontent(String wcontent) {
        this.wcontent = wcontent == null ? null : wcontent.trim();
    }

    public Date getWrelease() {
        return wrelease;
    }

    public void setWrelease(Date wrelease) {
        this.wrelease = wrelease;
    }
}