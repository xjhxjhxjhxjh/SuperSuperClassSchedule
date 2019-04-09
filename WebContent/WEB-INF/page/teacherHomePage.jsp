<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>teacherHomePage</title>
    <!-- 创建视口 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--导入jquery文件-->
    <script src="js/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
    <!--导入bootstrap.css文件-->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <!--导入bootstrap.js-->
    <script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
    <!--创建布局容器-->
	<div class="container-fluid"
		style="width: 100%; height: 72.25rem; background: url(img/login.jpg) no-repeat;"
		align="center">
		<div style="color: red">${teacher.tName}老师欢迎回来!!!</div>
		<form action="getApplyList" method="post">
		   <input type="hidden" name="tId" value="${teacher.tId}"> 
	       <input type="submit" value="获取申请选修的学生名单">
	    </form>
		<table border="1" style="height: 50%; width: 50%;">
			<tr>
				<td colspan="5" align="center">${teacher.tName}老师的课程信息</td>
			</tr>
			<tr>
				<td align="center" style="font-weight: bold;">课程编号</td>
				<td align="center" style="font-weight: bold;">课程名</td>
				<td align="center" style="font-weight: bold;">上课地点</td>
				<td align="center" style="font-weight: bold;">查询学生信息</td>
			</tr>
			<c:if test="${empty teacher.tList}">
			     <tr>
			         <td colspan="4" align="center">暂无课程</td>
			     </tr>
			</c:if>
			<c:if test="${not empty teacher.tList}">
			     <c:forEach items="${teacher.tList}" var="message">
			         <tr>
				         <td align="center">${message.cId}</td>
				         <td align="center">${message.cName}</td>
				         <td align="center">${message.cPlace}</td>
				         <td align="center">
				            <form action="findStudentMessage" method="post">
				               <input type="hidden" name="tId" value="${teacher.tId}"> 
				               <input type="hidden" name="cId" value="${message.cId}"> 
	                           <input type="submit" value="查询">
	                        </form>
	                     </td>
                     </tr>
			     </c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>
