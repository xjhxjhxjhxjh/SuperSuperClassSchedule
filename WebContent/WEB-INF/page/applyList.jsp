<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>applyList</title>
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
        <table border="1" style="height: 50%; width: 50%;">
            <tr>
                <td align="center" colspan="5">申请选课的学生名单</td>
            </tr>
            <tr>
                <td align="center" style="font-weight: bold;">申请学生编号</td>
                <td align="center" style="font-weight: bold;">申请学生名</td>
                <td align="center" style="font-weight: bold;">申请课程编号</td>
                <td align="center" style="font-weight: bold;">申请课程名</td>
                <td align="center" style="font-weight: bold;">编辑</td>
            </tr>
            <c:if test="${empty list}">
                <tr>
                    <td colspan="5">暂无申请的学生</td>
                </tr>
            </c:if>
            <c:if test="${not empty list}">
                <c:forEach items="${list}" var="message">
                    <tr>
                        <td align="center">${message.sId}</td>
                        <td align="center">${message.sName}</td>
                        <td align="center">${message.cId}</td>
                        <td align="center">${message.cName}</td>
                        <td>
                            <input type="button" id="btn1" value="同意" name=${message.sId}+${message.cId}+${message.tId}>
                            <input type="button" id="btn2" value="不同意" name=${message.sId}+${message.cId}+${message.tId}>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
</body>
<script type="text/javascript">
$(function () {
	$("input:button").click(function() {
		var str = this.name.split("+");
		if (this.id == "btn1"){
		    $.post("insCourse", {sId:str[0], cId:str[1], tId:str[2]}, function() {
		    	alert("已经同意该学生的请求");
		    	window.location.reload();
			})		    			
		}
		if (this.id == "btn2"){
			$.post("delApply", {sId:str[0], cId:str[1], tId:str[2]}, function() {
				alert("已经拒绝该学生的请求");
				window.location.reload();
			})
		}
	})
})
</script>
</html>
