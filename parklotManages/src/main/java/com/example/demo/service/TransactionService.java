package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Parkingrecord;
import com.example.demo.pojo.Reconciliation;
import com.example.demo.pojo.UserMoneyCount;

public interface TransactionService {

	List<Parkingrecord> selectRecord(String type,String type2,String type3,String Membership,
			String platenumber);
	
	List<Reconciliation> selectRecon(String type,String type2,String type3,String method);//对账统计查询
	
}
