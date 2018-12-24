<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@page import='java.util.*'%>
<%@page import='java.text.SimpleDateFormat'%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript">
			function checkUser() {
		var user = document.getElementById("user");
		var regs = /^[a-zA-Z0-9\u4e00-\u9fa5_]{6,18}$/;
		var message = document.getElementById("message1")
		if(regs.test(user.value)) {
			message.style.color = "greenyellow";
			message.innerHTML = "✔";
			return true;
 
		} else {
			message.style.color = "red";
			message.innerHTML = "请输入6-18位中英文用户名！";
			return false;
		}
	}
	
	function checkPassword() {
		var pass = document.getElementById("pass");
		var regs = /^[a-zA-Z0-9_]{6,12}$/;
		var message = document.getElementById("message2")
		if(regs.test(pass.value)) {
			message.style.color = "greenyellow";
			message.innerHTML = "✔";
			return true;
		} else {
			message.style.color = "red";
			message.innerHTML = "请输入6-12位中英文密码！";
			return false;
		}
	}
			</script>
</head>

<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						2009/11/20 <br />
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
				<h1>login</h1>
				<form action="${pageContext.request.contextPath }/user/login"
					method="post" onsubmit="checkAll();">
					<table cellpadding="0" cellspacing="0" border="0"
						class="form_table">
						<tr>
							<td valign="middle" align="right">username:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="name" id="user" required="required"
								onblur="checkUser()" /> <span id="message1"></span></td>
						</tr>
						<tr>
							<td valign="middle" align="right">password:</td>
							<td valign="middle" align="left"><input type="password"
								class="inputgri" name="password" required="required" id="pass"
								onblur="checkPassword()" /> <span id="message2"></span></td>
						</tr>
					</table>
					<p>
						<input type="submit" class="button" value="Submit &raquo;" /> <input
							type="button" class="button"
							onclick="location.href='${pageContext.request.contextPath }/regist.jsp'"
							value="Regist &raquo;" />
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
