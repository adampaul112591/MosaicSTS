package com.hybrid.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hybrid.domain.Dept;
import com.hybrid.mapper.DeptMapper;


@Repository
public class DeptDao {
	
	@Autowired
	DeptMapper mapper;
	
	public Dept readByDeptno(int deptno) {
		return mapper.selectByDeptno(deptno);
	}

	public int create(Dept dept) {
		return mapper.insert(dept);
	}
}
