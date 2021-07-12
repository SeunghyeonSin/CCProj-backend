<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 및 수정</title>
</head>
<body>
<h1>글 상세 및 수정</h1>
<h3>${nickname}님 환영합니다. <a href="logout">Logout</a></h3>
<hr>
<form method="post">
<input name="bnum" type="hidden" value=${board.bnum}>
<table>
	<tr>
		<td bgcolor="orange">제목</td>
		<td>
			<input name="title" type="text" value="${board.title}"/>
		</td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td>${board.nickname}</td>
	</tr>
	<tr>
		<td bgcolor="orange">이미지</td>
		<td><input name="fileName" type="file" value="${files.fileName}"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td>
			<textarea name="content" rows=40 cols=40>${board.content}</textarea>
		</td>
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
			<button type="submit" class="btn btn-info">글 수정</button>
		</td>
	</tr>
</table>
</form>
<hr>
<a href="/boardinsert">글등록</a>&nbsp;&nbsp;&nbsp;
<a href="/boarddelete?bnum=${board.bnum}">글삭제</a>&nbsp;&nbsp;&nbsp;
</body>
</html>