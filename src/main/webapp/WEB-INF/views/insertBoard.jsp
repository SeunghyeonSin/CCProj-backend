<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>새 글 등록</title>
</head>
<body>
<h1>새로운 글 등록 화면</h1>
${nickname}님 <a href="logout">Logout</a>
<hr>
<form method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td bgcolor="orange">제목</td>
		<td> <input name="title" type="text"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td><input name="nickname" type="text" value="${nickname}" readonly="readonly"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">이미지</td>
		<td><input type="file" name="file"></td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td><textarea name="content" rows="40" cols="40"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="submit" class="btn btn-info">새 글 등록</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>