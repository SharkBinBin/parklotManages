package com.example.demo.pojo;

import java.util.Date;

public class UserM {
    private Integer wid;

    private String mname;

    private String mnumber;

    private String mpassword;

    private String mphone;

    private Integer msex;

    private String midcard;

    private String mbankid;

    private String maddress;

    private String lpnumber;

    private Integer money;

    private String memail;

    private Date registrationdate;
    
    

    public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMidcard() {
		return midcard;
	}

	public void setMidcard(String midcard) {
		this.midcard = midcard;
	}

	public String getMbankid() {
		return mbankid;
	}

	public void setMbankid(String mbankid) {
		this.mbankid = mbankid;
	}

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



    public Integer getMsex() {
        return msex;
    }

    public void setMsex(Integer msex) {
        this.msex = msex;
    }

  
    public String getMaddress() {
        return maddress;
    }

    public void setMaddress(String maddress) {
        this.maddress = maddress == null ? null : maddress.trim();
    }

    public String getLpnumber() {
        return lpnumber;
    }

    public void setLpnumber(String lpnumber) {
        this.lpnumber = lpnumber == null ? null : lpnumber.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail == null ? null : memail.trim();
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }
}