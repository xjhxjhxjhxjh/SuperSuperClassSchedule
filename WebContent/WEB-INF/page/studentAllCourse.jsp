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
<script src="js/jquery-1.11.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<!--导入bootstrap.css文件-->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<!--导入bootstrap.js-->
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<!--创建布局容器-->
	<div class="container-fluid" style="width: 100%; height: 72.25rem; background: url(img/login.jpg) no-repeat;" align="center">
	    <form style="display: none" onkeydown="if(event.keyCode==13){event.keyCode=0;event.returnValue=false;}">
	             请选择老师
	       <select id="sel" name="apply">
                            
            </select>
            <input id="btn1" type="button" value="提交">
        </form>
		<table border="1" style="height: 50%; width: 50%;">
			<tr>
				<td colspan="4" align="center">本学期所有开设的课程</td>
			</tr>
			<tr>
				<td align="center" style="font-weight: bold;">课程名</td>
				<td align="center" style="font-weight: bold;">课程编号</td>
				<td align="center" style="font-weight: bold;">上课地点</td>
				<td align="center" style="font-weight: bold;">申请选课</td>
			</tr>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4" align="center">暂无课程</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
			     <c:forEach items= "${list}" var="course">
			         <tr>
                        <td align="center">${course.cName}</td>
                        
                        <td align="center">${course.cId}</td>
                        <td align="center">${course.cPlace}</td>
                        <td align="center">
                            <input name="btn2" type="button" value="申请" id="${course.cId}">
                        </td>
                    </tr>
			     </c:forEach>
			</c:if>
		</table>
	</div>
<script type="text/javascript">
$(function () {
	// 获得点击事件
	$("input[name='btn2']").click(function() {
		$.post("addCourse",{cId:this.id},function(data){
			//判断是否已经选择过该课程
			if (data == ""){
				alert("你已经有该课程，不能再次选课");
			} else {
			    // 清空表单内容
				$("#sel").empty();
				// 显示提交表单
				$("form").toggle();
				 var result = "";
				 for (var i = 0; i < data.length; i++){
					 result += ("<option value ="+data[i].tId+">"+data[i].tName+"</option>");
				 }
				 // 添加option
				 $("#sel").append(result);
			}
		})
	})
	
	// ajax提交表单
	$("#btn1").click(function() {
		var tId = $("#sel").val();
		$.post("applyCourse",{tId:tId}, function () {
		    alert("申请已经提交，等待教师审核");
		    $("form").toggle();
		})
	})
})
</script>
</html>
