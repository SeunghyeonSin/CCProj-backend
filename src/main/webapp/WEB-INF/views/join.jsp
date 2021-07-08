<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>사용자 가입</title>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>
<h1>사용자 가입</h1>
<hr>
<form method="post">
<table>
	<tr>
		<td bgcolor="orange">아이디</td>
		<td>
			<input name="memId" type="text"/>
			<input name="check" type="button" value="중복확인" class="idCheck">
			<p class="result">
				<span class="msg"></span>
			</p>
		</td>
	</tr>
	<tr>
		<td bgcolor="orange">비밀번호</td>
		<td><input name="memPassword" type="password"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">비밀번호확인</td>
		<td><input name="memPassword" type="password"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">이름</td>
		<td><input name="memName" type="text"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">닉네임</td>
		<td>
			<input name="memNickname" type="text"/>
			<input name="check" type="button" value="중복확인" class="nickCheck">
			<p class="result2">
				<span class="msg2"></span>
			</p>
		</td>
	</tr>
	<tr>
		<td bgcolor="orange">이메일</td>
		<td><input name="memEmail" type="text"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">구분</td>
		<td>
			<input name="memRole" type="radio" value="CAST"/>CAST
			<input name="memRole" type="radio" value="일반"/>일반
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="submit" id="submit" disabled="disabled" class="btn btn-info">가입하기</button>
		</td>
	</tr>
</table>
</form>
<hr>
<a href="/login">로그인화면가기</a>&nbsp;&nbsp;&nbsp;

<script> 
$(".idCheck").click(function() {
 
	var query = {id : $("#id").val()};
 
	$.ajax({
  		url : "/idCheck",
  		type : "post",
  		data : query,
  		success : function(data) {
   			if(data == 1) {
    			$(".result .msg").text("사용 불가");
    			$(".result .msg").attr("style", "color:#f00");
    			$("#submit").attr("disabled", "disabled");
   			} else {
   				$(".result .msg").text("사용 가능");
    			$(".result .msg").attr("style", "color:#00f");
    			$("#submit").removeAttr("disabled");
   			}
  		}
 	});  // ajax 끝
});

$(".nickCheck").click(function() {
	 
	var query = {nickname : $("#nickname").val()};
 
	$.ajax({
  		url : "/nickCheck",
  		type : "post",
  		data : query,
  		success : function(data) {
   			if(data == 1) {
    			$(".result2 .msg2").text("사용 불가");
    			$(".result2 .msg2").attr("style", "color:#f00");
    			$("#submit").attr("disabled", "disabled");
   			} else {
   				$(".result2 .msg2").text("사용 가능");
    			$(".result2 .msg2").attr("style", "color:#00f");
    			$("#submit").removeAttr("disabled");
   			}
  		}
 	});  // ajax 끝
});
</script>

</body>
</html>