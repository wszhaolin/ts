<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import='java.util.*'%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
         contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@page import='java.text.SimpleDateFormat'%>
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
            <form action="${pageContext.request.contextPath}/search/findAll" method="post">
              标题 :<input type="radio" name="aaa" value="title" ></br>
                内容 :<input type="radio" name="aaa" value="content"></br>
               作者： <input type="radio" name="aaa" value="author"></br>
                <input type="text" name="parse">
                <input type="submit" value="查询">
            </form>
            <table class="table">
                <tr class="table_header">
                    <td>ID</td>
                    <td>title</td>
                    <td>content</td>
                    <td>author</td>
                </tr>
                <c:forEach items="${requestScope.list}" var="list">
                    <tr class="row1">
                        <td>${list.id}</td>
                        <td>${list.title}</td>
                        <td>${list.content}</td>
                        <td>${list.poets.name}</td>
                    </tr>
                </c:forEach>
            </table>
            <!-- 分页功能 start -->
            <div align="center">
                <c:if test="${requestScope.pageNow != 1}">
                    <td>
                        <a href="${pageContext.request.contextPath}/search/findAll?pageNow=${requestScope.pageNow- 1}&&aaa=${requestScope.aaa}&&parse=${requestScope.parse}">上一页</a>
                    </td>
                </c:if>
                <c:if test="${requestScope.pageNow == 1}">
                    <td>
                        上一页
                    </td>
                </c:if>
                </tr>
                <tr>
                    <c:if test="${requestScope.pageNow < requestScope.pageCounts}">
                    <td colspan="4">
                        <a href="${pageContext.request.contextPath}/search/findAll?pageNow=${requestScope.pageNow+1}&&aaa=${requestScope.aaa}&&parse=${requestScope.parse}">下一页</a>
                    </td>
                    </c:if>
                    <c:if test="${requestScope.pageNow == requestScope.pageCounts}">
                    <td colspan="4">
                        下一页
                    </td>
                    </c:if>
                        当前为第${requestScope.pageNow}页  共:${requestScope.pageCounts}页
                        <a href="${pageContext.request.contextPath}/search/findAll?pageNow=1&&aaa=${requestScope.aaa}&&parse=${requestScope.parse}">首页</a>
                <a href="${pageContext.request.contextPath}/search/findAll?pageNow=${requestScope.pageCounts}&&aaa=${requestScope.aaa}&&parse=${requestScope.parse}">尾页</a>
            </div>
            <!-- 分页功能 End -->
            <p>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">ABC@126.com</div>
    </div>
</div>
</body>
</html>
