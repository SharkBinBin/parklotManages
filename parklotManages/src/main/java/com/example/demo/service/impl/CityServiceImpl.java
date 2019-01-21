package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CityMapper;
import com.example.demo.pojo.City;
import com.example.demo.service.CityService;
@Service
public class CityServiceImpl implements CityService{

	@Autowired
	public CityMapper cityMapper;
	
	@Override
	public List<City> SelectOne() {
		// TODO Auto-generated method stub
		List<City> list = cityMapper.SelectOne();
		return list;
	}

	
	
}
