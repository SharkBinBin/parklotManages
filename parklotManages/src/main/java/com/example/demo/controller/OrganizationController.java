package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Garage;
import com.example.demo.service.LoginService;
import com.example.demo.service.OrganizationService;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping("/select")
	public String select(@RequestParam(value=("Oname"),required=false)String Oname,Model model){
		Oname="zhangsan";
			List<Garage> list=organizationService.seleclist(Oname);
			model.addAttribute("list", list);
			return "index";
	}
	public String insert(Garage garage,Model model) {
		int count = organizationService.insert(garage);
		return "/organization/select";
	}
}
