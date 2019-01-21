package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.GarageMapper;
import com.example.demo.pojo.Garage;
import com.example.demo.pojo.UserMoneyCount;
import com.example.demo.service.GarageService;

@Service
public class GarageServiceImpl implements GarageService{

	@Autowired
	GarageMapper garageMapper;
	
	@Override
	public List<Garage> SelectAll(String type, String type2, String type3) {
		// TODO Auto-generated method stub
		return garageMapper.SelectAll(type,type2,type3);
	}


	@Override
	public List<Garage> selectThird(Integer siteId) {
		// TODO Auto-generated method stub
		return garageMapper.selectThird(siteId);
	}


	@Override
	public List<UserMoneyCount> selectCharges(String type, String type2,String type3,String platenumber,
			String method,String date,String date1) {
		// TODO Auto-generated method stub
		return garageMapper.selectCharges(type, type2, type3, platenumber, method, date, date1);
	}


}
