package com.example.demo.pojo;

import java.util.Date;

public class Transaction {
    private Integer tid;

    private Integer gid;

    private Date ttime;

    private String ttype;

    private Double tmoney;

    private String remark;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Date getTtime() {
        return ttime;
    }

    public void setTtime(Date ttime) {
        this.ttime = ttime;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype == null ? null : ttype.trim();
    }

    public Double getTmoney() {
        return tmoney;
    }

    public void setTmoney(Double tmoney) {
        this.tmoney = tmoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}