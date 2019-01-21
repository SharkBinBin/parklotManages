package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.TransactionMapper;
import com.example.demo.pojo.Parkingrecord;
import com.example.demo.pojo.Reconciliation;
import com.example.demo.pojo.UserMoneyCount;
import com.example.demo.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{

		@Autowired
		TransactionMapper transactionMapper;
	
	@Override
	public List<Parkingrecord> selectRecord(String type, String type2, String type3, String Membership,
			String platenumber) {
		// TODO Auto-generated method stub
		return transactionMapper.selectRecord(type,type2,type3,Membership,platenumber);
	}

	@Override
	public List<Reconciliation> selectRecon(String type, String type2, String type3, String method) {
		// TODO Auto-generated method stub
		return transactionMapper.selectRecon(type, type2, type3, method);
	}

}
