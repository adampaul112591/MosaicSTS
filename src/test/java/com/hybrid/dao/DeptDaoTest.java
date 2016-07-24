package com.hybrid.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.MainApplicationTests;
import com.hybrid.domain.Dept;

public class DeptDaoTest extends MainApplicationTests {
	
	@Autowired
	DeptDao dao;
	
	@Test
	public void testReadByDeptno() {
		System.out.println(dao.readByDeptno(10));
	}
	
	@Test
	public void testInsert() {
		Dept dept = new Dept(55, "홍길동", "서울");
		
		System.out.println(dept + " rtn = " +  dao.create(dept));
	}	

}
