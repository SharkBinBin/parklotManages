package com.example.demo.pojo;

import java.util.Date;

public class Record {
    private Integer rid;

    private Integer gid;

    private Integer mid;

    private Date rstarttime;

    private Date rendtime;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Date getRstarttime() {
        return rstarttime;
    }

    public void setRstarttime(Date rstarttime) {
        this.rstarttime = rstarttime;
    }

    public Date getRendtime() {
        return rendtime;
    }

    public void setRendtime(Date rendtime) {
        this.rendtime = rendtime;
    }
}