<%@page import="org.springframework.dao.DuplicateKeyException"%>
<%@page import="com.hybrid.dao.DeptDao"%>
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
<h1>deptRegist.jsp</h1>
<h1><a href="index.html">index.html</a></h1>

<%
	System.out.println("### index.jsp...");
	ServletContext servletContext = this.getServletContext();
	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
	
	DeptDao dao = wac.getBean(DeptDao.class);
	
	String deptno = request.getParameter("deptno");
	String dname = "홍길동" + deptno;
	String loc = "부산" + deptno;
	
	Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
	log(dept.toString());
	try {
		int rtn = dao.create(dept);
		System.out.println("rtn = " + rtn);
	} catch (DuplicateKeyException e) {
		log("dao.create DuplicateKeyException error...", e);
	}
%>


</body>
</html>