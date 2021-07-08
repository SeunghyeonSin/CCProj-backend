<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta contentType='application/json' charset="UTF-8">
<title>게시판</title>
</head>
<body>
<h1>게시판</h1>
<hr>
<h3> ${nickname} 님 환영합니다.<a href="logout"> Logout </a></h3>
<br>
<form method="post">
<table>
	<tr>
		<td>
			<select name="searchCondition">
				<option value="title">제 목
				<option value="nickname">작성자
				<option value="content">내 용
			</select>
			<input name="searchKeyword" type="text">
			<input type="submit" value="검색">
</table>
</form>
<br>
<table>
	<tr>
		<th bgcolor="orange">번호</th>
		<th bgcolor="orange">제목</th>
		<th bgcolor="orange">작성자</th>
		<th bgcolor="orange">등록일</th>
		<th bgcolor="orange">조회수</th>
	</tr>
	<c:forEach items="${boardlist}" var="board">
		<tr>
			<td> ${board.bnum} </td>
			<td> <a href="/boarddetail?bnum=${board.bnum}">${board.title}</a></td>
			<td> ${board.nickname} </td>
			<td> ${board.date} </td>
			<td> ${board.cnt} </td>
		</tr>
	</c:forEach>
</table>
<br>
<a href="/boardinsert">새 글 등록</a>
<hr>
</body>
</html>