<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.baizhi.entity.*,java.util.*" %>
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <input type="button" class="button" value="返回上一级"
                       onclick="location='${pageContext.request.contextPath}/person/findAll'" /> <br />
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Datetime
                    </td>
                    <td>
                        Handler
                    </td>
                    <td>
                        Result
                    </td>
                </tr>
                <c:forEach items="${requestScope.all}" var="list">
                    <tr class="row1">
                        <td>
                                ${list.id}
                        </td>
                        <td>
                                ${list.username}
                        </td>
                        <td>
                                ${list.datetime}
                        </td>
                        <td>
                                ${list.handle}
                        </td>
                        <td>
                                ${list.result}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            Liuxw@126.com
        </div>
    </div>
</body>
</html>
