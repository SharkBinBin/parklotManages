package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.LoginMapper;
import com.example.demo.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginMapper loginMapper;
	@Override
	public int login(String number, String password) {
		// TODO Auto-generated method stub
		return loginMapper.login(number,password);
	}

}
