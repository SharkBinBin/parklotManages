package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.Garage;
import com.example.demo.pojo.UserMoneyCount;

import io.lettuce.core.dynamic.annotation.Param;

public interface GarageMapper {
	@Select("<script>SELECT * FROM city,site,garage WHERE city.CityId=garage.CityId AND site.SiteId=garage.SiteId"
			+ "<if test='type!=null and type!=\"\"'> and garage.Cityid =#{type}</if>"
			+ "<if test='type2!=null and type!=\"\"'> and garage.Siteid =#{type2}</if>"
			+ "<if test='type3!=null and type!=\"\"'> and garage.Gid =#{type3}</if>"
			+ "</script>")
	List<Garage> SelectAll(@Param("type")String type,@Param("type2")String type2,@Param("type3")String type3);
	
	@Select("select count(*) from city,site,garage where ")
	List<Garage> selectcount();
	
	@Select("select * from garage where siteId=#{siteid}")
	List<Garage> selectThird(@Param("siteid")int siteid);	
	
	/*@Select("SELECT * FROM `transaction` AS t  INNER JOIN garage AS g ON t.GId=g.GId "
			+ "INNER JOIN city AS c ON g.CityId=c.CityId  "
			+ "INNER JOIN site AS s ON s.SiteId = g.SiteId " 
			+ "INNER JOIN user_m AS u ON u.WId = t.mid " 
			+ "WHERE 1=1"
			+ "<if test='type!=null && type!=\"\"'> and c.CityId =#{type}</if>"
			+ "<if test='type2!=null && type2!=\"\"'> and s.siteId =#{type2}</if>"
			+ "<if test='type3!=null && type3!=\"\"'> AND g.GId=#{type3}</if>"
			+ "<if test='platenumber!=null && platenumber!=\"\"'> AND u.LpNumber=#{platenumber}</if>"
			+ "<if test='method!=null && method!=\"\"'> AND t.TType=#{method}</if>"
			+ "<if test='date!=null && date!=\"\"'> AND t.Sdate>=#{date}</if>"
			+ "<if test='date1!=null && date1!=\"\"'> AND t.Edate<=#{date1}</if>")*/
	@Select("<script>"+" select * from transaction1 as t  inner join garage as g on t.GId=g.GId "
			+ "inner join city as c on g.CityId=c.CityId  "
			+ "inner join site as s on s.SiteId = g.SiteId " 
			+ "inner join user_m as u on u.WId = t.mid " 
			+ "where 1=1 "
			+ "<if test='type != null and type!=\"\"'> and c.CityId =#{type}</if> "
			+ "<if test='type2 != null and type2!=\"\"'> and s.siteId =#{type2}</if> "
			+ "<if test='type3 != null and type3!=\"\"'> and g.GId=#{type3}</if> "
			+ "<if test='platenumber != null and platenumber!=\"\"'> and u.LpNumber=#{platenumber}</if> "
			+ "<if test='method != null and method!=\"\"'> and t.TType=#{method}</if> "
			+" </script>")
	List<UserMoneyCount> selectCharges(@Param("type")String type,
			@Param("type2")String type2,
			@Param("type3")String type3,
			@Param("platenumber")String platenumber,
			@Param("method")String method,@Param("date")String date,@Param("date1")String date1);
	
}
