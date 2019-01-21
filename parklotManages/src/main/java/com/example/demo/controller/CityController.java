package com.example.demo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.City;
import com.example.demo.pojo.Garage;
import com.example.demo.pojo.Site;
import com.example.demo.service.CityService;
import com.example.demo.service.GarageService;
import com.example.demo.service.SiteService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class CityController {
	
	@Autowired
	 CityService cityService;

	@Autowired
	 GarageService garageService;
	
	@Autowired
	 SiteService siteService;
	
	List<Garage> garagelist = null;
	
	@RequestMapping("test")//停车场统计查询
	public String selectOne(Model model,@RequestParam(value="type",required=false)String type,
			@RequestParam(value="type2",required=false)String type2,
			@RequestParam(value="type3",required=false)String type3,
			@RequestParam(value="currPageNo",required=false,defaultValue="1")int currPageNo) {
		int pageSize=3;//每页有几条数据
		PageHelper.startPage(currPageNo,pageSize);
		
		List<Garage> list2 = garageService.SelectAll(type,type2,type3);
		PageInfo<Garage> pageinfo =new PageInfo<>(list2);
		garagelist = pageinfo.getList();
		
		List<City> citylist = cityService.SelectOne();
		//for循环统计
		int size=0;//总车位
		int afterSize=0;//剩余车位
		for(int i=0; i<list2.size();i++) {
			Garage garage = list2.get(i);
			size=size+garage.getGsize();
			afterSize=afterSize+garage.getGparksize();
		}
		model.addAttribute("size",size);
		model.addAttribute("afterSize",afterSize);
		model.addAttribute("list", garagelist);
		model.addAttribute("currPageNo", currPageNo);
		model.addAttribute("list2", list2);
		model.addAttribute("citylist", citylist); 
		return "backstage/test";
		
	}
	//查询二级
	@RequestMapping("tests.json")
	@ResponseBody
	public List<Site> selectSec(int cityId) {
			List<Site> sitelist = siteService.selectSec(cityId);
		return sitelist;

	}
	//查询三级
	@RequestMapping("testx.json")
	@ResponseBody
	public List<Garage> selectThird(int siteId) {
			List<Garage> garaglist = garageService.selectThird(siteId);
		return garaglist;

	}
	
	@RequestMapping("excel")//导出
	public String excelDowload(HttpServletResponse response) throws IOException {
		if(garagelist.size()>0) {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet("车位统计");//excel页面
			HSSFRow row1=sheet.createRow(0);//创建一行
			row1.createCell(0).setCellValue("序号");//创建一个单元格
			row1.createCell(1).setCellValue("城市");
			row1.createCell(2).setCellValue("区域");
			row1.createCell(3).setCellValue("停车场");
			row1.createCell(4).setCellValue("总车位");
			row1.createCell(5).setCellValue("剩余车位");
			
			for(int i=0;i<garagelist.size();i++) {
				HSSFRow rows=sheet.createRow(i+1);
				rows.createCell(0).setCellValue(i+1);
				rows.createCell(1).setCellValue(garagelist.get(i).getCityName());
				rows.createCell(2).setCellValue(garagelist.get(i).getSiteName());
				rows.createCell(3).setCellValue(garagelist.get(i).getGname());
				rows.createCell(4).setCellValue(garagelist.get(i).getGsize());
				rows.createCell(5).setCellValue(garagelist.get(i).getGparksize());
			}
			OutputStream output=response.getOutputStream();
	        response.reset();
	        response.setHeader("Content-disposition", "attachment; filename=停车位统计"+System.currentTimeMillis()+".xls");
	        response.setContentType("application/msexcel");
	        wb.write(output);
	        output.close();
	        return null;
		}	
		return null;
	}
}
