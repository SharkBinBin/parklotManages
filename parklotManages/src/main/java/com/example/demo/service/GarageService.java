package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Garage;
import com.example.demo.pojo.UserMoneyCount;

public interface GarageService {
	
	

	List<Garage> SelectAll(String type, String type2, String type3);//查看车位全部统计带三级分类
	
	List<Garage> selectThird(Integer siteId);//查询三级表
	
	List<UserMoneyCount> selectCharges(String type, String type2,String type3,String platenumber,
			String method,String date,String date1);//查询收费统计
}
