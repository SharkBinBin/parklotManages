package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.SiteMapper;
import com.example.demo.pojo.Site;
import com.example.demo.service.SiteService;

@Service
public class SiteServiceImpl implements SiteService{

	@Autowired
	SiteMapper siteMapper;
	
	@Override
	public List<Site> selectSec(Integer cityId) {
		// TODO Auto-generated method stub
		return siteMapper.selectSec(cityId);
	}

}
