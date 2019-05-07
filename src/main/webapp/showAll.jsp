<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
 <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

	$(function(){
		
		$(".deleteId").click(function(){
			
			var $url=this.href;
			
			
			 $("#deleteForm").attr("action",$url);
			
			//提交表单
			
			 $("#deleteForm").submit();
			
			return false; 
		});
		
	});
</script>
</head>
<body>
	<div class="container">
	<h1 align="center">妖怪管理系统----姜子牙专用版</h1>
		<table class="table table-bordered table-striped">
			<tr>
				<th>妖怪编号</th>
				<th>妖怪姓名</th>
				<th>妖怪邮箱</th>
				<th>妖怪生日</th>
				<th>入职时间</th>
				<th>门派名称</th>
				<th>删除</th>
				<th>修改</th>
			</tr>
			
			<c:forEach items="${mList }" var="m">
				<tr>
					<td>${m.monsterId}</td>
					<td>${m.monstername}</td>
					<td>${m.email}</td>
					<td>
					<fmt:formatDate value="${m.brithday}" pattern="yyyy-MM-dd"/>
					</td>
					<td>
					<fmt:formatDate value="${m.entryday}" pattern="yyyy-MM-dd"/>
					</td>
					<td>${m.school.name}</td>
					<td><a href="deleteMonster/${m.monsterId}" class="deleteId  btn btn-danger">删除</a></td>
					<td><a href="updateUI/${m.monsterId}" class="btn btn-primary">修改</a></td>
				</tr>
			</c:forEach>
		</table>
		<!-- 准备一个隐藏表单 -->
		<form action=""  method="post" id="deleteForm">
			<input type="hidden" name="_method" value="DELETE">
		</form>
	</div>
</body>
</html>