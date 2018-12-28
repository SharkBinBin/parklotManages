package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@RequestMapping("/login")
	public String login(@RequestParam(value=("number"),required=false)String number,
			@RequestParam(value=("password"),required=false)String password,Model model){
		number="zhangsan";
		password="123";
		int count=loginService.login(number,password);
		if (count>0) {
			return "index";
		}else {
			return "login"; 
		}
		
	}
	
}
