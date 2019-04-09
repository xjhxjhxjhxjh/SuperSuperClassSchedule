<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>teacherStudent</title>
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
        <div style="color: red">${teacher.tName}老师欢迎回来!!!</div>
        <form style="display: none" onkeydown="if(event.keyCode==13){event.keyCode=0;event.returnValue=false;}">
                 请添加成绩(-1表示缺考,-2表示暂无考试成绩,-3表示考试作弊,-4表示缓考)<br>
            <input id="text1" type="text" name="grade">
            <input name="btn1" type="button" value="提交">
        </form>
        <table border="1" style="height: 50%; width: 50%;">
            <tr>
                <td colspan="6" align="center">${teacher.tName}老师的学生信息</td>
            </tr>
            <tr>
                <td align="center" style="font-weight: bold;">课程编号</td>
                <td align="center" style="font-weight: bold;">课程名</td>
                <td align="center" style="font-weight: bold;">学生编号</td>
                <td align="center" style="font-weight: bold;">学生名</td>
                <td align="center" style="font-weight: bold;">成绩</td>
                <td align="center" style="font-weight: bold;">编辑成绩</td>
            </tr>
            <c:if test="${empty list}">
                <td colspan="6" align="center">暂无该课程的学生信息</td>
            </c:if>
            <c:if test="${not empty list}">
                <c:forEach items="${list}" var="message">
                    <tr>
						<td align="center">${message.cId}</td>
						<td align="center">${message.cName}</td>
						<td align="center">${message.sId}</td>
						<td align="center">${message.sName}</td>
						<c:if test="${message.gScore eq -2}">
							<td align="center" id="grade">暂无考试成绩</td>
						</c:if>
						<c:if test="${message.gScore eq -1}">
							<td align="center" id="grade">缺考</td>
						</c:if>
						<c:if test="${message.gScore eq -3}">
							<td align="center" id="grade">考试作弊</td>
						</c:if>
						<c:if test="${message.gScore eq -4}">
							<td align="center" id="grade">缓考</td>
						</c:if>
						<c:if test="${message.gScore gt -1}">
							<td align="center" id="grade">${message.gScore}</td>
						</c:if>
						<td align="center">
						    <input type="button" value="编辑" name="btn2" id="${message.sId}+${message.cId}">
						</td>
					</tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
</body>
<script type="text/javascript">
$(function() {
	// 编辑成绩
    $("input[name='btn2']").click(function() {
    	// 获取学生id和课程id
        var str = this.id.split("+");
        // 显示提交表单
        $("form").toggle();
        $("input[name='btn1']").click(function() {
        	var grade = $("input[name='grade']").val();
        	if (grade >= -4 && grade <= 1000){
		        $.post("editGrade",{gSId:str[0],gCId:str[1],gScore:grade},function() {
		        	alert("编辑成功");
		        	$("form").toggle();
		        	// 获得更新后学生的成绩并修改页面
			        $.post("findGrade",{gSId:str[0],gCId:str[1]},function(data){
	                    $("#grade").html(data);
	                })
		        });
        	}else {
        		alert("请输入正确的成绩!!!");
        	}
        })
    })
})
</script>
</html>
