package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ParkingLotsSrvice;
@Controller
@RequestMapping("/ParkingLots")
public class ParkingLotsController {
	@Autowired
	private ParkingLotsSrvice parkingLotsSrvice;
}
