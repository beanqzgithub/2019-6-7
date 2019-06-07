<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a {
		text-decoration: none;
		cursor: pointer;
	}
</style>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="addUser.jsp">添加用户</a>

	<h3>用户信息</h3>
<table class="table">
	<tr>
	<th>id</th>
	<th>name</th>
	<th>birthday</th>
	<th>money</th>
	<th>操作</th>
	</tr>
	<c:forEach items="${page.list }" var="u">
	<tr>
	<th>${u.id}</th>
	<th>${u.name}</th>
	<th>${u.birthday}</th>
	<th>${u.money}</th>
	<th>
	<a href="User_delete?id=${u.id }">删除</a> | 
	<a href="User_updateUI?id=${u.id }">修改</a></th>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5">
		<c:if test="${page.p!=1 }">
		<a href="User_find?p=1">首页</a>
		</c:if>
		<a href="User_find?p=${p.prev }">上一页</a>
		<c:forEach begin="${page.startPage }" end="${page.endPage }" var="x">
			<c:if test="${page.p==x }">
			<font color="red">${x }</font>
			</c:if>		
			<c:if test="${page.p!=x }">
			<a href="User_find?p=${x }">${x }</a>
			</c:if>		
		</c:forEach>
		<a href="User_find?p=${p.next }">下一页</a>
		<c:if test="${page.p!=page.maxPage }">
		<a href="User_find?p=${page.maxPage }">末页</a>
		</c:if>
		${page.p }
		/
		${page.maxPage }	
		<form action="User_find"  style="display:inline;"> 
			跳到第<input type="text" />页<button type="submit">go</button>
		</form>
		</td>
	</tr>
</table>	
</body>
</html>