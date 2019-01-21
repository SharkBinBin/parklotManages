package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.Site;

import io.lettuce.core.dynamic.annotation.Param;

public interface SiteMapper {
	
	@Select("select * from site where cityId=#{cityid}")
	List<Site> selectSec(@Param("cityid")int cityid);
}
