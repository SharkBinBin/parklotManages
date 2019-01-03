package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Garage;

public interface OrganizationService {

	List<Garage> seleclist(String oname);

	int insert(Garage garage);

}
