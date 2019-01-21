package com.example.demo.pojo;

public class Garage {
    private Integer gid;

    private String gname;

    private Integer cityid;

    private Integer siteid;

    private Integer gsize;

    private Integer gparksize;
    /**
     * 只为前段显示数据
     */
    private String cityName;
    
    private String siteName;

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
		this.gname = gname;
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public Integer getSiteid() {
		return siteid;
	}

	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
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

    
}