package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
	@Select("Select * from user_a Where MNumber = #{number} and MPassword = #{password}")
	int login(@Param("number")String number,@Param("password")String password);

}
