<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<form action="/write-ok.post" method="post">
		<input type="text" name="post-name" placeholder="게시글 제목">
		<input type="text" name="post-content" placeholder="게시글 내용">
		<button>완료</button>
	</form>
</body>
</html>