<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>쪽지</title>
</head>
<body>
<h1>쪽지</h1>
<hr>
<form method="post">
<table>
	<tr>
		<td bgcolor="orange">제목</td>
		<td><input name="messagetitle" type="text"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">보내는사람</td>
		<td><input name="sendnick" type="text" value="${nickname}" readonly="readonly"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">받는사람</td>
		<td><input name="receinick" type="text"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td><input name="content" type="text"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="submit" class="btn btn-info">보내기</button>
		</td>
	</tr>
</table>
</form>
<hr>
<a href="/messagelist?receinick=${nickname}">쪽지목록가기</a>&nbsp;&nbsp;&nbsp;
</body>
</html>