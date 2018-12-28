package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.UserM;

public interface UserMMapper {

		@Select("select * from User_M where MNumber =  #{Mname}   and MPassword =#{Mpwd}")
		List<UserM> Login(@Param("Mname")String Name,@Param("Mpwd")String Password);
}
