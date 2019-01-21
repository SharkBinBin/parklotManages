package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Site;

public interface SiteService {

	List<Site> selectSec(Integer cityId);
}
