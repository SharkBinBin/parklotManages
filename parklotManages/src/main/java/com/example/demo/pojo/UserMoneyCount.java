package com.example.demo.pojo;
/**
 * 用户收费统计实体类（返回页面属性）
 * @author asus
 *
 */
public class UserMoneyCount {
	private String cityName;
	private String siteName;
	private String gname;
	private String lpnumber;
	private String mnumber;
	private String sdate;
	private String edate;
	private String ttype;
	private int tmoney;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getLpnumber() {
		return lpnumber;
	}
	public void setLpnumber(String lpnumber) {
		this.lpnumber = lpnumber;
	}
	public String getMnumber() {
		return mnumber;
	}
	public void setMnumber(String mnumber) {
		this.mnumber = mnumber;
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
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	public int getTmoney() {
		return tmoney;
	}
	public void setTmoney(int tmoney) {
		this.tmoney = tmoney;
	}
}
