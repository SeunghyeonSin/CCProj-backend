<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta contentType='application/json' charset="UTF-8">
<title>쪽지</title>
</head>
<body>
<h1>쪽지</h1>
<hr>
<h3> ${nickname} 님 환영합니다.<a href="logout"> Logout </a></h3>
<br>
<table>
	<tr>
		<th bgcolor="orange">작성내용</th>
		<th bgcolor="orange">작성날짜</th>
	</tr>
	<c:forEach items="${usercomment}" var="comment">
		<tr>
			<td> ${comment.content} </td>
			<td> ${comment.date} </td>
		</tr>
	</c:forEach>
</table>
<br>
<a href="/mypage?memId=${id}">마이페이지</a>
<hr>
</body>
</html>