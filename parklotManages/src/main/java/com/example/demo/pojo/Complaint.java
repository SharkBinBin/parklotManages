package com.example.demo.pojo;

import java.util.Date;

public class Complaint {
    private Integer cid;

    private Integer userMid;

    private Date cdate;

    private Integer userAid;

    private Date processingtime;

    private Integer state;

    private String copinion;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUserMid() {
        return userMid;
    }

    public void setUserMid(Integer userMid) {
        this.userMid = userMid;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Integer getUserAid() {
        return userAid;
    }

    public void setUserAid(Integer userAid) {
        this.userAid = userAid;
    }

    public Date getProcessingtime() {
        return processingtime;
    }

    public void setProcessingtime(Date processingtime) {
        this.processingtime = processingtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCopinion() {
        return copinion;
    }

    public void setCopinion(String copinion) {
        this.copinion = copinion == null ? null : copinion.trim();
    }
}