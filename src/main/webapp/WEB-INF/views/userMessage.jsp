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
<form method="post">
<table>
	<tr>
		<td>
			<select name="searchCondition">
				<option value="messagetitle">제 목
				<option value="sendnick">받는사람
				<option value="content">내 용
				<option value="date">보낸날짜
			</select>
			<input name="searchKeyword" type="text">
			<input type="submit" value="검색">
</table>
</form>
<br>
<table>
	<tr>
		<th bgcolor="orange">제목</th>
		<th bgcolor="orange">받는사람</th>
		<th bgcolor="orange">보낸날짜</th>
	</tr>
	<c:forEach items="${usermessage}" var="message">
		<tr>
			<td> <a href="/messageread?messagenum=${message.messagenum}">${message.messagetitle}</a></td>
			<td> ${message.receinick} </td>
			<td> ${message.date} </td>
		</tr>
	</c:forEach>
</table>
<br>
<a href="/messagesend">쪽지 보내기</a>
<br>
<a href="/mypage?memId=${id}">마이페이지</a>
<hr>
</body>
</html>