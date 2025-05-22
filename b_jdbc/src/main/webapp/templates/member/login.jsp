<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
   <form action="/member/login" method="post" name="login-form">
      <div>
         <input type="text" name="memberEmail" placeholder="이메일 입력">
      </div>
      <div>
         <input type="password" name="memberPassword" placeholder="비밀번호 입력">
      </div>
      <div>
         <button>로그인</button>
      </div>
   </form>
</body>
</html>







