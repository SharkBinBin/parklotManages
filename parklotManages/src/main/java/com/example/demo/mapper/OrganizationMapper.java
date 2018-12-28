package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.Garage;

public interface OrganizationMapper {
	@Select("select * from Garage")
	List<Garage> selectlist(@Param("oname")String oname);

}
