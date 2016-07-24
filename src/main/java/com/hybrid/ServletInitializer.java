package com.hybrid;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Component;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("###########################################");
		System.out.println("SpringBootServletInitializer.configure()...");
		System.out.println("###########################################");
		return application.sources(MainApplication.class);
	}

	
}
