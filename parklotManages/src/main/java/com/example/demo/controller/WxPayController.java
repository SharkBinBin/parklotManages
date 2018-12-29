package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.WxRequestParam;
import com.example.demo.util.*;

@Controller
public class WxPayController {
	
	@RequestMapping("pay")
	@ResponseBody
	public String pay(String body,String money,HttpSession session) {
		WxRequestParam param = new WxRequestParam();
		param.setBody(body);
		param.setTotal_fee(money);
		param.setOut_trade_no(String.valueOf(System.currentTimeMillis()));
		
		session.setAttribute("orderNo", param.getOut_trade_no());
	
		String codeUrl=WxPayUtil.getCodeUrl(param);
		return codeUrl;
	}
	
	@RequestMapping("query")
	@ResponseBody
	public Object queryOrderState(HttpSession session) {
		String orderId=(String) session.getAttribute("orderNo");
		WxRequestParam param = new WxRequestParam();
		param.setOut_trade_no(orderId);
		boolean result=WxPayUtil.queryOrderState(param);
		return result;
	}
	
	@RequestMapping(value="/login.do")
	public String login(){
		return "login";
	}
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("success")
	public String success() {
		return "success";
	}
	
}
