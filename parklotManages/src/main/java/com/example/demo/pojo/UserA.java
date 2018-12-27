package com.example.demo.pojo;

import java.util.Date;

public class UserA {
    private Integer wid;

    private String mname;

    private String mnumber;

    private Integer mpassword;

    private String departmentid;

    private Integer dutyid;

    private Integer midcard;

    private Date registrationdate;

    private Integer aphone;

    private Integer garageid;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public String getMnumber() {
        return mnumber;
    }

    public void setMnumber(String mnumber) {
        this.mnumber = mnumber == null ? null : mnumber.trim();
    }

    public Integer getMpassword() {
        return mpassword;
    }

    public void setMpassword(Integer mpassword) {
        this.mpassword = mpassword;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid == null ? null : departmentid.trim();
    }

    public Integer getDutyid() {
        return dutyid;
    }

    public void setDutyid(Integer dutyid) {
        this.dutyid = dutyid;
    }

    public Integer getMidcard() {
        return midcard;
    }

    public void setMidcard(Integer midcard) {
        this.midcard = midcard;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }

    public Integer getAphone() {
        return aphone;
    }

    public void setAphone(Integer aphone) {
        this.aphone = aphone;
    }

    public Integer getGarageid() {
        return garageid;
    }

    public void setGarageid(Integer garageid) {
        this.garageid = garageid;
    }
}