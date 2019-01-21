package com.example.demo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mapper.GarageMapper;
import com.example.demo.pojo.City;
import com.example.demo.pojo.Garage;
import com.example.demo.pojo.UserMoneyCount;
import com.example.demo.service.CityService;
import com.example.demo.service.GarageService;
import com.github.pagehelper.PageHelper;

@Controller
public class GarageController {

	@Autowired
	CityService cityService;
	
	@Autowired
	GarageService garageService;
	
	List<UserMoneyCount> listchar=null;
	
	@RequestMapping("statistics")
	public String selectFee(Model model) {
		
		return "backstage/fee";
	}
	
	@RequestMapping("statistics1")//查询一级分类的
	@ResponseBody
	public List<City> statistics1(Model model) {
		List<City> citylist = cityService.SelectOne();
		
		return citylist;
	}
	
	@RequestMapping("selectAll")
	public String selectCharges(Model model,String type, String type2,String type3,String platenumber,
			String method,String date,String date1) {

		 listchar= garageService.selectCharges(type, type2, type3, platenumber, method, date, date1);
		int size=0;
		for(int i=0;i<listchar.size();i++) {
			UserMoneyCount usermoneyCount=listchar.get(i);
			size=size+usermoneyCount.getTmoney();
		}
		model.addAttribute("size",size);
		model.addAttribute("listchar",listchar);
		return "backstage/fee";
		
	}
	
	@RequestMapping("feeExcel")
	public String excelDowload(HttpServletResponse response) throws IOException {
		if(listchar.size()>0) {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet("收费统计");
			HSSFRow row1=sheet.createRow(0);
			row1.createCell(0).setCellValue("序号");
			row1.createCell(1).setCellValue("城市");
			row1.createCell(2).setCellValue("区域");
			row1.createCell(3).setCellValue("停车场");
			row1.createCell(4).setCellValue("车牌号");
			row1.createCell(5).setCellValue("会员账号");
			row1.createCell(6).setCellValue("停车开始时间");
			row1.createCell(7).setCellValue("离场时间");
			row1.createCell(8).setCellValue("收费方式");
			row1.createCell(9).setCellValue("交款金额");
			
			for(int i=0;i<listchar.size();i++) {
				HSSFRow rows=sheet.createRow(i+1);
				rows.createCell(0).setCellValue(i+1);
				rows.createCell(1).setCellValue(listchar.get(i).getCityName());
				rows.createCell(2).setCellValue(listchar.get(i).getSiteName());
				rows.createCell(3).setCellValue(listchar.get(i).getGname());
				rows.createCell(4).setCellValue(listchar.get(i).getLpnumber());
				rows.createCell(5).setCellValue(listchar.get(i).getMnumber());
				rows.createCell(6).setCellValue(listchar.get(i).getSdate());
				rows.createCell(7).setCellValue(listchar.get(i).getEdate());
				String typeMoney=null;
				if(listchar.get(i).getTtype().equals("1")) {
					typeMoney="停车场自收";
				}else {
					typeMoney="平台代扣";
				}
				rows.createCell(8).setCellValue(typeMoney);
				rows.createCell(9).setCellValue(listchar.get(i).getTmoney());
			}
			OutputStream output=response.getOutputStream();
	        response.reset();
	        System.out.println();
	        response.setHeader("Content-disposition", "attachment; filename=收费统计"+System.currentTimeMillis()+".xls");
	        response.setContentType("application/msexcel");
	        wb.write(output);
	        output.close();
	        return null;
		}
		
		return null;
	}
	
}
