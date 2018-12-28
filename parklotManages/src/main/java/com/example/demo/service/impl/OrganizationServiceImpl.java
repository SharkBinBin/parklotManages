package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.OrganizationMapper;
import com.example.demo.pojo.Garage;
import com.example.demo.service.OrganizationService;
@Service
public class OrganizationServiceImpl implements OrganizationService{
	@Autowired
	private OrganizationMapper organizationMapper;
	@Override
	public List<Garage> seleclist(String oname) {
		// TODO Auto-generated method stub
		return organizationMapper.selectlist(oname);
	}

}
