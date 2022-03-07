<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} detail page</h1>
	<h3>글제목 : ${dto.title}</h3>
	<h3>내용: ${dto.contents}</h3>
	<h3>작성자 : ${dto.writer}</h3>
	<h3>작성자 : ${dto.regDate}</h3>
	<h3>조회수 : ${dto.hit}</h3>
	
	<a href="./list">List</a>
	<a href="./delete?num=${notice.num}">Delete</a>
</body>
</html>