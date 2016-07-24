package com.hybrid.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hybrid.domain.Dept;


@Mapper
public interface DeptMapper {
	  @Select("SELECT * FROM dept WHERE deptno = #{deptno}")
	  Dept selectByDeptno(int deptno);
	  
	  @Insert("insert into dept values (#{deptno}, #{dname}, #{loc})")
	  int insert(Dept dept);
	  
	  @Select("SELECT 999 FROM dual")
	  int getTest();
}
