package com.example.demo.pojo;

import java.util.Date;

public class Transaction {
    private Integer tid;

    private Integer gid;

    private String ttype;

    private Double tmoney;

    private String remark;
    
    private int mid;
    
    private String sdate;
    
    private String edate;
    
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
    
    public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}
	
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}