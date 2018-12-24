<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import='java.util.*'%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@page import='java.text.SimpleDateFormat'%>
<%@page import='com.baizhi.entity.User'%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
<script type="text/javascript">
			function showTime(){
			    nowtime=new Date();
			    year=nowtime.getFullYear();
			    month=nowtime.getMonth()+1;
			    date=nowtime.getDate();
			    document.getElementById("mytime").innerText=year+"年"+month+"月"+date+" "+nowtime.toLocaleTimeString();
			}

			setInterval("showTime()",1000);
		</script>
<title>emplist</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
					<h1 id="title">
						<span id=mytime></span>
					</h1>
					<br/>
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="#">main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<shiro:authenticated>
				<h1>Welcome <shiro:principal/></h1>
					<a href="${pageContext.request.contextPath}/user/logout">[登出]</a>
				</shiro:authenticated>
				<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>Name</td>
						<td>Salary</td>
						<td>Age</td>
						<td>sex</td>
						<td>Operation</td>
					</tr>
					<c:forEach items="${requestScope.list}" var="list">
						<tr class="row1">
							<td>${list.id}</td>
							<td>${list.name}</td>
							<td>${list.salary}</td>
							<td>${list.sex}</td>
							<td>${list.age}</td>
							<shiro:hasRole name="root">

							<td><a
								href="${pageContext.request.contextPath }/person/delete?id=${list.id}">delete
									emp</a>&nbsp; <a
								href="${pageContext.request.contextPath}/person/findOne?id=${list.id}">update
									emp</a></td>
							</shiro:hasRole>

						</tr>
					</c:forEach>
				</table>
				<!-- 分页功能 start -->
				<div align="center">
					<font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
					${page.pageNow} 页</font> <a href="${pageContext.request.contextPath}/person/findPerson?pageNow=1">首页</a>
					<c:choose>
						<c:when test="${page.pageNow - 1 > 0}">
							<a href="${pageContext.request.contextPath}/person/findPerson?pageNow=${page.pageNow - 1}">上一页</a>
						</c:when>
						<c:when test="${page.pageNow - 1 <= 0}">
							<a href="${pageContext.request.contextPath}/person/findPerson?pageNow=1">上一页</a>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${page.totalPageCount==0}">
							<a href="${pageContext.request.contextPath}/person/findPerson?pageNow=${page.pageNow}">下一页</a>
						</c:when>
						<c:when test="${page.pageNow + 1 < page.totalPageCount}">
							<a href="${pageContext.request.contextPath}/person/findPerson?pageNow=${page.pageNow + 1}">下一页</a>
						</c:when>
						<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
							<a href="${pageContext.request.contextPath}/person/findPerson?pageNow=${page.totalPageCount}">下一页</a>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${page.totalPageCount==0}">
							<a href="${pageContext.request.contextPath}/person/findPerson?pageNow=${page.pageNow}">尾页</a>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/person/findPerson?pageNow=${page.totalPageCount}">尾页</a>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- 分页功能 End -->
				<p>
					<shiro:hasRole name="root">
					<input type="button" class="button" value="Add Employee"
						onclick="location='${pageContext.request.contextPath }/addPerson.jsp'" />
					<input type="button" class="button" value="tranpation list" onclick="location='${pageContext.request.contextPath}/tranpation/findAll'"/>
					</shiro:hasRole>
				</p>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>
</html>
