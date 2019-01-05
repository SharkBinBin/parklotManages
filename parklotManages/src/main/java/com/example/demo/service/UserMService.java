package com.example.demo.service;

import java.util.List;


import com.example.demo.pojo.UserM;

public interface UserMService {
	
	Boolean Login(String Mname,String Mpassword);
	Boolean register(UserM userM);
	List<UserM> Query(int Mid);
}
