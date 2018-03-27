package com.tanoak.dao;


import com.tanoak.pojo.Hello;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface HelloDao {

	@Select("SELECT * FROM hello WHERE id = #{id}")
	Hello findById(@Param("id") Integer id);
	
	List<Hello> findAll();
}
