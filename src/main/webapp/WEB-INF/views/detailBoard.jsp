<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
</head>
<body>
<h1>글 상세</h1>
<h3>${nickname}님 환영합니다. <a href="logout">Logout</a></h3>
<hr>
<form method="post">
<input name="bnum" type="hidden" value=${board.bnum}>
<table>
	<tr>
		<td bgcolor="orange">제목</td>
		<td>${board.title}</td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td>${board.nickname}</td>
	</tr>
	<tr>
		<td bgcolor="orange">이미지</td>
		<td>${board.file}</td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td>${board.content}</td>
	</tr>
	<tr>
		<td bgcolor="orange">등록일</td>
		<td readonly="readonly"/>${board.date}</td>
	</tr>
	<tr>
		<td bgcolor="orange">조회수</td>
		<td readonly="readonly"/>${board.cnt}</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		</td>
	</tr>
</table>
</form>
<hr>
<a href="/boardupdate?bnum=${board.bnum }">글수정/a>&nbsp;&nbsp;&nbsp;
<a href="/boarddelete?bnum=${board.bnum}">글삭제</a>&nbsp;&nbsp;&nbsp;
</body>
</html>