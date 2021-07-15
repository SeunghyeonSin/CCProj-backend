<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="commentS.jsp" %>
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
<form action="/boarddetail" method="post">
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
		<td bgcolor="orange">첨부파일</td>
		<td><a href="/fileDown/${files.bnum}">${files.fileOriName}</a></td>
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
</form action="/updateLiketo" method="post">
	<input class="btn btn-default" type="button" value="좋아요">
<form>
</form>
<hr>
<a href="/boardupdate?bnum=${board.bnum}">글수정</a>&nbsp;&nbsp;&nbsp;
<a href="/boarddelete?bnum=${board.bnum}">글삭제</a>&nbsp;&nbsp;&nbsp;
<!--  댓글  -->
    <div class="container">
        <label for="content">댓글</label>
        <form name="commentInsertForm">
            <div class="input-group">
               <input type="hidden" name="bnum" value="${board.bnum}"/>
               <input type="text" class="form-control" id="content" name="content" placeholder="내용을 입력하세요.">
               <span class="input-group-btn">
                    <button class="btn btn-default" type="button" name="commentInsertBtn">등록</button>
               </span>
              </div>
        </form>
    </div>
    
    <div class="container">
        <div class="commentList"></div>
    </div>
</div>
</body>
</html>