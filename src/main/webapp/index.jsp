<%@page import="com.hybrid.domain.Dept"%>
<%@page import="com.hybrid.mapper.DeptMapper"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp</title>
</head>
<body>
<h1>index.jsp</h1>
<h1><a href="index.html">index.html</a></h1>

<%
	System.out.println("### index.jsp...");
	ServletContext servletContext = this.getServletContext();
	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
	
	DeptMapper mapper = wac.getBean(DeptMapper.class);
	
	for (int i=10; i<40; i+=10) {
		Dept dept = mapper.getDept(i);
		System.out.println(dept);
	}
%>


</body>
</html>