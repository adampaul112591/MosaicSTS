package com.hybrid;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hybrid.mapper.DeptMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
@WebAppConfiguration
public class MainApplicationTests {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	DeptMapper mapper;
	
	@Test
	public void contextLoads() {
		System.out.println(dataSource);
		System.out.println(mapper);
	}

}
