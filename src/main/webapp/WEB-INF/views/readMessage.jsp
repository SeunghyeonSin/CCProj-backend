<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="commentS.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지</title>
</head>
<body>
<h1>쪽지</h1>
<h3>${nickname}님 환영합니다. <a href="logout">Logout</a></h3>
<hr>
<form action="/messageread" method="post">
<input name="messagenum" type="hidden" value=${read.messagenum}>
<table>
	<tr>
		<td bgcolor="orange">제목</td>
		<td>${read.messagetitle}</td>
	</tr>
	<tr>
		<td bgcolor="orange">보낸사람</td>
		<td>${read.sendnick}</td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td>${read.content}</td>
	</tr>
	<tr>
		<td bgcolor="orange">보낸날짜</td>
		<td>${read.date}</td>
	</tr>
</table>
</form>
<hr>
<a href="/messagelist?receinick=${nickname}">쪽지목록</a>&nbsp;&nbsp;&nbsp;
<a href="/messagedelete?messagenum=${read.messagenum}">쪽지삭제</a>&nbsp;&nbsp;&nbsp;
</body>
</html>