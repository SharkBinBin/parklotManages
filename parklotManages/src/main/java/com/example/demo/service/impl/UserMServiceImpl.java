package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMMapper;
import com.example.demo.pojo.Externalusers;
import com.example.demo.pojo.UserM;
import com.example.demo.service.UserMService;
@Service
public class UserMServiceImpl implements UserMService{
	
	@Autowired
	UserMMapper usermmapper;

	
	
	public Boolean Login(String Mname, String Mpassword) {
		List<UserM> list =  usermmapper.Login(Mname, Mpassword);
		if (list.size()!=0) {
			return true;
		}
		return false;
	}



	@Override
	public Boolean register(UserM userM) {
		int count = usermmapper.register(userM);
		if (count>0) {
			return true;
		}
		return false;
	}



	@Override
	public List<UserM> Query(int Mid) {
		return usermmapper.Query(Mid);
	}



	@Override
	public List<Externalusers> Queryexternal(String membership, String fullname, String certificates,
			String phonenumber, String platenumber) {
		// TODO Auto-generated method stub
		return usermmapper.Queryexternal(membership, fullname, certificates, phonenumber, platenumber);
	}
	
}
