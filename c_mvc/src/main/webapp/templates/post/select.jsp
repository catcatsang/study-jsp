<%@page import="java.util.List"%>
<%@page import="com.app.domain.vo.PostVO"%>
<%@page import="com.app.domain.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
<style>
	 table {
            width: 80%;
            border-collapse: collapse;
            border: 2px solid black;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: white;
        }
</style>
</head>

<body>
<%%>
	<h2>회원 목록</h2>
	<table>
		<thead>
			<tr>
				<th>제목</th>
				<th>내용</th>
				<th>수정날짜</th>
				<th>작성자</th>
				
			</tr>
		</thead>
	<%
                // request에서 postList 가져오기
                List<PostVO> postList = (List<PostVO>) request.getAttribute("post");

                // postList가 null이 아니고 데이터가 있을 때 반복
                if (postList != null && !postList.isEmpty()) {
                    
                    for (PostVO postData : postList) {
            %>
                        <tr>
                            
                            <td><%= postData.getPostTitle()%></td>
                            <td><%= postData.getPostContent() %></td>
                            <td><%= postData.getUpdatedDate() %></td>
                            <td><%= postData.getMemberId() %></td>
                            
                        </tr>
            <%
                        
                    }
                } else {
            %>
                    <tr>
                        <td colspan="4">등록된 게시글이 없습니다.</td>
                    </tr>
            <%
                }
            %>

	
</body>
</html>