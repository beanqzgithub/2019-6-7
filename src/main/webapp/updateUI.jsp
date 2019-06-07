<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>修改用户信息</h3>
	<form action="User_update" method="post">
	<input type="hidden" name="id" value="${user.id }"/>
	name:<input type="text" name="name" value="${user.name }"/><br/>
	birthday:<input type="text" name="birthday" value="${user.birthday }"/><br/>
	money:<input type="text" name="money" value="${user.money }"/>
	<button>修改</button>
	</form>

</body>
</html>