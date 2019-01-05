package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.UserM;

public interface UserMMapper {

		@Select("select * from User_M where MNumber =  #{Mname}   and MPassword =#{Mpwd}")
		List<UserM> Login(@Param("Mname")String Name,@Param("Mpwd")String Password);
		
		@Insert("insert user_m values (0, #{userm.mname},#{userm.mnumber},#{userm.mpassword},#{userm.mphone},#{userm.msex},#{userm.midcard},#{userm.mbankid},#{userm.maddress},#{userm.lpnumber},'0',#{userm.memail},CURDATE() )")
		int register(@Param("userm")UserM userm);
		/*where Wid = #{Mid}*/
		@Select("select * from User_M ")
		List<UserM> Query(@Param("Mid")int Mid);
}
