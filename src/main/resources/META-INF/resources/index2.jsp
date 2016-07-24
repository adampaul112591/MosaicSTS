<%@page import="org.springframework.core.io.Resource"%>
<%@page import="org.springframework.core.io.support.PathMatchingResourcePatternResolver"%>
<%@page import="java.util.Set"%>
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
<title>hello.jsp##</title>
</head>
<body>
<h1>index.jsp@@@</h1>
<h1><a href="index.html">index.html</a></h1>

<%
	System.out.println("### index2.jsp...");
	Set<String> paths = application.getResourcePaths("/");
	for (String p : paths) {
		log(p);
	}
	
	PathMatchingResourcePatternResolver path = new PathMatchingResourcePatternResolver();
	Resource[] rs = path.getResources("classpath:META-INF/resources/**/*.jsp");
	
	for (Resource r : rs) {
		String f = r.getURL().toString();
		log(f);
		String uri = f.substring(f.indexOf("META-INF/resources/") + "META-INF/resources/".length());
		log(uri);
%>
	<a href="<%=uri%>"><%=uri%></a><br>
<%		
	}
%>


</body>
</html>