package com.example.demo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.City;
import com.example.demo.pojo.Parkingrecord;
import com.example.demo.pojo.Reconciliation;
import com.example.demo.pojo.Transaction;
import com.example.demo.pojo.UserMoneyCount;
import com.example.demo.service.CityService;
import com.example.demo.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	CityService cityService;
	
	@Autowired
	TransactionService transactionService;
	
	List<Parkingrecord> listRecord=null;
	
	List<Reconciliation> listRecon=null;
	
	@RequestMapping("selectRecord")
	@ResponseBody
	public List<City> statistics1(Model model) {
		List<City> citylist = cityService.SelectOne();
		
		return citylist;
	}
	
	@RequestMapping("Record")//查询停车记录
	public String selectRecord(Model model,String type,String type2,String type3,String membership,
			String platenumber) {
		
		listRecord=transactionService.selectRecord(type, type2, type3, membership, platenumber);
		
		model.addAttribute("listRecord", listRecord);
		
		return "backstage/parking";
	}
	
	@RequestMapping("Reconciliation")//查询对账统计
	public String selectRecon(Model model,String type,String type2,String type3,String method) {
		 listRecon=transactionService.selectRecon(type, type2, type3, method);
		int moeny=0;
		for(int i=0; i<listRecon.size();i++) {
			Reconciliation reconciliation=listRecon.get(i); 
			moeny=moeny+reconciliation.getMoney();
		}
		model.addAttribute("moeny",moeny);
		model.addAttribute("listRecon",listRecon);
		return "backstage/reconciliation";
	}
	
	@RequestMapping("parkingExcel")
	public String excelDowload(HttpServletResponse response) throws IOException {
		if(listRecord.size()>0) {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet =wb.createSheet("停车记录");
			HSSFRow row1=sheet.createRow(0);
			row1.createCell(0).setCellValue("序号");
			row1.createCell(1).setCellValue("城市");
			row1.createCell(2).setCellValue("区域");
			row1.createCell(3).setCellValue("停车场");
			row1.createCell(4).setCellValue("会员账号");	
			row1.createCell(5).setCellValue("车牌号");
			row1.createCell(6).setCellValue("停车开始时间");
			row1.createCell(7).setCellValue("离场时间");
			
			for(int i=0;i<listRecord.size();i++) {
				HSSFRow rows=sheet.createRow(i+1);
				rows.createCell(0).setCellValue(i+1);
				rows.createCell(1).setCellValue(listRecord.get(i).getCityName());
				rows.createCell(2).setCellValue(listRecord.get(i).getSiteName());
				rows.createCell(3).setCellValue(listRecord.get(i).getgName());
				rows.createCell(4).setCellValue(listRecord.get(i).getMnumber());
				rows.createCell(5).setCellValue(listRecord.get(i).getLpnumber());
				rows.createCell(6).setCellValue(listRecord.get(i).getsDate());
				rows.createCell(7).setCellValue(listRecord.get(i).geteDate());
				
			}
			OutputStream output=response.getOutputStream();
	        response.reset();
	        response.setHeader("Content-disposition", "attachment; filename=停车记录"+System.currentTimeMillis()+".xls");
	        response.setContentType("application/msexcel");
	        wb.write(output);
	        output.close();
	        return null;
		}
		return null;
		
	}
	
		@RequestMapping("reconciliationExcel")
		public String reconciliationExcel(HttpServletResponse response) throws IOException {
			if(listRecon.size()>0) {
				HSSFWorkbook wb = new HSSFWorkbook();
				HSSFSheet sheet=wb.createSheet("对账统计");
				HSSFRow row1=sheet.createRow(0);
				row1.createCell(0).setCellValue("序号");
				row1.createCell(1).setCellValue("城市");
				row1.createCell(2).setCellValue("区域");
				row1.createCell(3).setCellValue("停车场");
				row1.createCell(4).setCellValue("发生时间");
				row1.createCell(5).setCellValue("收费类型");
				row1.createCell(6).setCellValue("金额");
				row1.createCell(7).setCellValue("备注");
				
				for(int i=0;i<listRecon.size();i++) {
					HSSFRow rows=sheet.createRow(i+1);
					rows.createCell(0).setCellValue(i+1);
					rows.createCell(1).setCellValue(listRecon.get(i).getCityName());
					rows.createCell(2).setCellValue(listRecon.get(i).getSiteName());
					rows.createCell(3).setCellValue(listRecon.get(i).getgName());
					rows.createCell(4).setCellValue(listRecon.get(i).getsDate());
					String typeMoney=null;
					if(listRecon.get(i).gettType().equals("1")) {
						typeMoney="停车场自收";
					}else {
						typeMoney="平台代扣";
					}
					rows.createCell(5).setCellValue(typeMoney);
					rows.createCell(6).setCellValue(listRecon.get(i).getMoney());
					rows.createCell(7).setCellValue(listRecon.get(i).getRemark());
				}
				OutputStream output=response.getOutputStream();
		        response.reset();
		        response.setHeader("Content-disposition", "attachment; filename=对账统计"+System.currentTimeMillis()+".xls");
		        response.setContentType("application/msexcel");
		        wb.write(output);
		        output.close();
		        return null;
			}
			return null;
		} 
	
}
