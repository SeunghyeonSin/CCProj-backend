<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 관리</title>
</head>
<body>
<h1>사용자 관리</h1>
<hr>
<form method="post">
<input name="memId" type="hidden" value=${user.memId}>
<table>
	<tr>
		<td bgcolor="orange">아이디</td>
		<td>${user.memId}</td>
	</tr>
	<tr>
		<td bgcolor="orange">비밀번호</td>
		<td>
			<input name="memPasswordd" type="password" value="${user.memPassword}"/>
		</td>
	</tr>
	<tr>
		<td bgcolor="orange">이름</td>
		<td>
			<input name="memName" type="text" value="${user.memName}"/>
		</td>
	</tr>
	<tr>
		<td bgcolor="orange">닉네임</td>
		<td>
			<input name="memNickname" type="text" value="${user.memNickname}"/>
		</td>
	</tr>
	<tr>
		<td bgcolor="orange">이메일</td>
		<td>
			<input name="memEmail" type="text" value="${user.memEmail}"/>
		</td>
	</tr>
	<tr>
		<td bgcolor="orange">구분</td>
		<td>
			<input name="memRole" type="text" value="${user.memRole}"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="submit" class="btn btn-info">사용자 수정</button>
		</td>
	</tr>
</table>
</form>
<hr>
<a href="/userlist">사용자목록 가기</a>&nbsp;&nbsp;&nbsp;
<a href="/userinsert">사용자등록</a>&nbsp;&nbsp;&nbsp;
<a href="/userdelete?id=${user.memId}">사용자삭제</a>&nbsp;&nbsp;&nbsp;
</body>
</html>