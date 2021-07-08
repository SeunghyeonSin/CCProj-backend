<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta contentType='application/json' charset="UTF-8">
<title>사용자 목록</title>
</head>
<body>
<h1> 사용자 목록 </h1>
	<table width=100% border=2 cellpadding=1>
	<tr>
		<th bgcolor="orange">아이디</th>
		<th bgcolor="orange">이 름</th>
		<th bgcolor="orange">닉네임</th>
		<th bgcolor="orange">이메일</th>
		<th bgcolor="orange">구 분</th>
	</tr>
	<c:forEach items="${userlist}" var="user">
		<tr>
			<td> <a href="/userupdate?memId=${user.memId}">${user.memId} </td>
			<td> ${user.memName}</td>
			<td> ${user.memNickname}</a></td>
			<td> ${user.memEmail} </td>
			<td> ${user.memRole} </td>
		</tr>
	</c:forEach>
</table>
<form method="post">
<table>
	<tr>
		<td>
			<select name="searchCondition">
				<option value="memId">아이디
				<option value="memName">이 름
				<option value="memNickname">닉네임
				<option value="memEmail">이메일
			</select>
			<input name="searchKeyword" type="text">
			<input type="submit" value="검색">
</table>
</form>
<a href="/boardlist">게시판관리</a>&nbsp;&nbsp;&nbsp;
<hr>
</body>
</html>