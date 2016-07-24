package com.hybrid.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.MainApplicationTests;

public class DeptMapperTest extends MainApplicationTests {
	
	@Autowired
	DeptMapper mapper;
	
	@Test
	public void testDeptMapper() {
		System.out.println(mapper.selectByDeptno(10));
	}

}
