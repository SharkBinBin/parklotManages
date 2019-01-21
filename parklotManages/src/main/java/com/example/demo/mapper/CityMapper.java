package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.City;

public interface CityMapper {

	@Select("select * from city ")
	List<City> SelectOne();
}
