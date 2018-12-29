package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.UserM;
import com.example.demo.service.UserMService;

@Controller
public class UserMcontroller {
	
	
	@Autowired
	UserMService usermservice;
	
	@RequestMapping("/start")
	public String go() {
		
		return "Front/index";
	}
	
	@RequestMapping("/login")
	public String   Login(@RequestParam(value="name")String Nname,@RequestParam("pwd")String Npwd) {
		Boolean flag = usermservice.Login( Nname,Npwd);
		if (flag) {
			return "success";
		}
		return "error";
		
		
	}
	
	@RequestMapping("/reg")
	public String register(UserM userm) {
		Boolean flag = usermservice.register(userm);
		 if (flag) {
			return "success";
		}		  
		return "error";
	}
}
