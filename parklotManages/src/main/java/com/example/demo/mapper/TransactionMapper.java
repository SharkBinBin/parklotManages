package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.Parkingrecord;
import com.example.demo.pojo.Reconciliation;
import com.example.demo.pojo.UserMoneyCount;

import io.lettuce.core.dynamic.annotation.Param;
@Mapper
public interface TransactionMapper {

	
	@Select("<script>"+" select * from transaction1 as t  inner join garage as g on t.GId=g.GId "
			+ "inner join city as c on g.CityId=c.CityId  "
			+ "inner join site as s on s.SiteId = g.SiteId " 
			+ "inner join user_m as u on u.WId = t.mid " 
			+ "where 1=1 "
			+ "<if test='type != null and type!=\"\"'> and c.CityId =#{type}</if> "
			+ "<if test='type2 != null and type2!=\"\"'> and s.siteId =#{type2}</if> "
			+ "<if test='type3 != null and type3!=\"\"'> and g.GId=#{type3}</if> "
			+ "<if test='platenumber != null and platenumber!=\"\"'> and u.LpNumber=#{platenumber}</if> "
			+ "<if test='membership != null and membership!=\"\"'> and u.MNumber=#{membership}</if> "
			+" </script>")
	List<Parkingrecord> selectRecord(@Param("type")String type,
			@Param("type2")String type2, 
			@Param("type3")String type3,
			@Param("membership")String membership,
			@Param("platenumber")String platenumber);
	
	
	
	@Select("<script>"+" select * from transaction1 as t  inner join garage as g on t.GId=g.GId "
			+ "inner join city as c on g.CityId=c.CityId  "
			+ "inner join site as s on s.SiteId = g.SiteId " 
			+ "inner join user_m as u on u.WId = t.mid " 
			+ "where 1=1 "
			+ "<if test='type != null and type!=\"\"'> and c.CityId =#{type}</if> "
			+ "<if test='type2 != null and type2!=\"\"'> and s.siteId =#{type2}</if> "
			+ "<if test='type3 != null and type3!=\"\"'> and g.GId=#{type3}</if> "
			+ "<if test='method != null and method!=\"\"'> and  t.TType=#{method}</if> "
			+" </script>")
	List<Reconciliation> selectRecon(@Param("type")String type,
			@Param("type2")String type2,
			@Param("type3")String type3,
			@Param("method")String method);

}
