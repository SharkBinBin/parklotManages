package com.example.demo.pojo;

public class Garage {
    private Integer gid;

    private String gname;

    private String gcity;

    private String gsite;

    private Integer gsize;

    private Integer gparksize;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getGcity() {
        return gcity;
    }

    public void setGcity(String gcity) {
        this.gcity = gcity == null ? null : gcity.trim();
    }

    public String getGsite() {
        return gsite;
    }

    public void setGsite(String gsite) {
        this.gsite = gsite == null ? null : gsite.trim();
    }

    public Integer getGsize() {
        return gsize;
    }

    public void setGsize(Integer gsize) {
        this.gsize = gsize;
    }

    public Integer getGparksize() {
        return gparksize;
    }

    public void setGparksize(Integer gparksize) {
        this.gparksize = gparksize;
    }
}