package com.example.demo.pojo;

public class Site {
    private Integer siteid;

    private Integer cityid;

    private String sitename;

    public Integer getSiteid() {
        return siteid;
    }

    public void setSiteid(Integer siteid) {
        this.siteid = siteid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename == null ? null : sitename.trim();
    }
}