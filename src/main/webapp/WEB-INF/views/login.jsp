<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta contentType='application/json' charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1> 로그인 </h1>
<hr>
<form method="post">
<table>
	<tr>
		<td bgcolor="orange">아이디</td>
		<td><input type="text" name="memId"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">비밀번호</td>
		<td><input type="password" name="memPassword"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인">
			<a href="/userinsert"><input type = "button" value = "회원가입"></a>
		</td>
	</tr>
</table>
</form>
<hr>
</body>
</html>