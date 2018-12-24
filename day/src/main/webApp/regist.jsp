<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import='java.util.*'%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@page import='java.text.SimpleDateFormat'%>
<html>
<head>
<title>regist</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />

</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
							<span id=mytime></span><br />
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
				<h1>注册</h1>
				<form action="${pageContext.request.contextPath}/user/regis"
					method="post">
					<table cellpadding="0" cellspacing="0" border="0"
						class="form_table">
						<tr>
							<td valign="middle" align="right">用户名:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="name"  id="user" />
								<span id="txtNickName"></span>
								</td>
						</tr>
						<tr>
							<td valign="middle" align="right">密码:</td>
							<td valign="middle" align="left"><input type="password"
								class="inputgri" name="password"  id="pass" />
								<span id="txp"></span></td>
						</tr>

						<tr>
							<td valign="middle" align="right">验证码: <img id="code"
								src="${pageContext.request.contextPath}/code/code" />
								<a href="javascript:;" onclick="Code();">换一张</a>
							</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="Code" /></td>
						</tr>
					</table>
					<p>
						<input type="submit" class="button" value="Submit &raquo;" />
					</p>
				</form>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>
</html>
