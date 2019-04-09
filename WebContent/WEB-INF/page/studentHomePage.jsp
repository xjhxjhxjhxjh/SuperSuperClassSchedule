<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>studentHomePage</title>
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
	<div class="container-fluid" style="width: 100%; height: 72.25rem; background: url(img/login.jpg) no-repeat;" align="center">
	   <div style="color: red">${student.sName}欢迎回来!!!</div>
	   <a href="${pageContext.request.contextPath}/findAllCourse">查询本学期开课的所有课程</a>
	   <table border="1" style="height: 50%; width: 50%; ">
	       <tr>
                <td colspan="5" align="center">${student.sName}的课程信息</td>
           </tr>
	       <tr>
	           <td align="center" style="font-weight: bold;">课程名</td>
	           <td align="center" style="font-weight: bold;">课程编号</td>
	           <td align="center" style="font-weight: bold;">任课老师</td>
	           <td align="center" style="font-weight: bold;">上课地点</td>
	           <td align="center" style="font-weight: bold;">成绩</td>
	       </tr>
	       <c:if test="${empty student.sList}">
	           <tr>
	               <td colspan="5" align="center">暂无课程信息</td>
	           </tr>
	       </c:if>
	       <c:if test="${not empty student.sList}">
	           <c:forEach items="${student.sList}" var="message">
	               <tr>
	                   <td align="center">${message.cName}</td>
	                   <td align="center">${message.cId}</td>
	                   <td align="center">${message.tName}</td>
	                   <td align="center">${message.cPlace}</td>
	                   <c:if test="${message.gScore eq -2}">
	                       <td align="center">暂无考试成绩</td>
	                   </c:if>
	                   <c:if test="${message.gScore eq -1}">
	                       <td align="center">缺考</td>
	                   </c:if>
	                   <c:if test="${message.gScore eq -3}">
	                       <td align="center">考试作弊</td>
	                   </c:if>
	                   <c:if test="${message.gScore eq -4}">
	                       <td align="center">缓考</td>
	                   </c:if>
	                   <c:if test="${message.gScore gt -1}">
	                       <td align="center">${message.gScore}</td>
	                   </c:if>
	               </tr>
	           </c:forEach>
	       </c:if>
	   </table>
	</div>
</body>
</html>
