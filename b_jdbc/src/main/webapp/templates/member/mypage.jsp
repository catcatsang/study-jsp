<%@page import="com.app.domain.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
   #check {
      color: red;
   }
</style>
</head>
<body>
   <% 
      MemberVO member = (MemberVO)request.getAttribute("member");
      String email = request.getParameter("email");
   %>
   
   <a href="/member/logout">로그아웃</a>
   
   <h1><%=member.getName()%>님 환영합니다.</h1>
   <form action="/member/update" method="post">
      <div>
         <input type="text" name="memberEmail" value="<%=member.getMemberEmail()%>">
      </div>
      <%if(email != null) {%>
      <div>
         <p id="check">
            이미 존재하는 이메일입니다.
         </p>
      <%} %>
      </div>
      <div>
         <input type="text" name="memberName" value="<%=member.getName()%>">
      </div>
      <div>
         <input type="text" name="memberAge" value="<%=member.getAge()%>">
      </div>
      <div>
         <input type="radio" name="memberGender" value="남자" <%=member.getGender().equals("남자") ? "checked" : ""%>> 남자
         <input type="radio" name="memberGender" value="여자" <%=member.getGender().equals("여자") ? "checked" : ""%>> 여자
         <input type="radio" name="memberGender" value="선택 안함" <%=member.getGender().equals("선택 안함") ? "checked" : ""%>> 선택 안함
      </div>
      <button>수정 완료</button>
   </form>
   <a>회원 탈퇴</a>
</body>
</html>









