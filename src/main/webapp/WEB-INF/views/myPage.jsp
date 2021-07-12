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
<a href="/messagelist?receinick=${nickname}">쪽지</a>
<br>
<a href="/boardlist">게시글 목록</a>
<form method="post">
<table>
	<tr>
		<td bgcolor="orange"><a href="/userupdate?memId=${id}">내정보수정</a></td>
		<td bgcolor="orange"><a href="/userboardlist?nickname=${nickname}">작성한게시글</a></td>
		<td bgcolor="orange"><a href="/usercommentlist?nickname=${nickname}">작성한댓글</a></td>
		<td bgcolor="orange"><a href="/usermessagelist?sendnick=${nickname}">보낸쪽지</a></td>
		<td bgcolor="orange"><a href="/deleteuser?memId=${id}">사용자탈퇴</a></td>
	</tr>
</table>
</form>
</body>
</html>