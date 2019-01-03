package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.UserM;
import com.example.demo.service.UserMService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("UserM")
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
			return "Front/success";
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
	
	
	@RequestMapping("/QueryUser")
	public String QueryUser(@RequestParam(value="id")int Mid,Map<String, Object> result) {
		PageHelper.startPage(2,2);
		List<UserM> list  = usermservice.Query(Mid);
		
		
		 PageInfo<UserM> personPageInfo = new PageInfo<>(list);
	        //得到分页中的person条目对象
	        List<UserM> pageList = personPageInfo.getList();
	        result.put("userlist", pageList);
		return "Front/userinfo";
	}
}
