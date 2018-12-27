package com.example.demo.pojo;

import java.util.Date;

public class Notice {
    private Integer nid;

    private String nname;

    private String ncontent;

    private Integer userAid;

    private Date nreleasedate;

    private String nscope;

    private Integer nstatus;

    private Date nvaliditydate;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname == null ? null : nname.trim();
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent == null ? null : ncontent.trim();
    }

    public Integer getUserAid() {
        return userAid;
    }

    public void setUserAid(Integer userAid) {
        this.userAid = userAid;
    }

    public Date getNreleasedate() {
        return nreleasedate;
    }

    public void setNreleasedate(Date nreleasedate) {
        this.nreleasedate = nreleasedate;
    }

    public String getNscope() {
        return nscope;
    }

    public void setNscope(String nscope) {
        this.nscope = nscope == null ? null : nscope.trim();
    }

    public Integer getNstatus() {
        return nstatus;
    }

    public void setNstatus(Integer nstatus) {
        this.nstatus = nstatus;
    }

    public Date getNvaliditydate() {
        return nvaliditydate;
    }

    public void setNvaliditydate(Date nvaliditydate) {
        this.nvaliditydate = nvaliditydate;
    }
}