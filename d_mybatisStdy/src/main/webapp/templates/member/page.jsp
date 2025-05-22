<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="/join-ok.member" method="post" name="">
 		<input type="text" name="memberEmail" placeholder="이메일을 입력하세요">
 		<input type="text" name="memberPassword" placeholder="비밀번호를 입력하세요">
 		<input type="text" name="memberName" placeholder="이름을 입력하세요" >
 		<input type="text" name="memberAge" placeholder="나이를 입력하세요.">
 		<input type="radio" name="memberGender" value="남자">남자
 		<input type="radio" name="memberGender" value="여자">여자
 		<input type="radio" name="memberGender" value="헬리콥터" checked="checked">헬리콥터
 		<button>완료</button>
	</form>
</body>
</html>