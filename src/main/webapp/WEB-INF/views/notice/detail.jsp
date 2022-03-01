<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Notice detail page</h1>
	<h3>글제목 : ${notice.title}</h3>
	<h3>내용: ${notice.contents}</h3>
	<h3>작성자 : ${notice.writer}</h3>
	<h3>작성자 : ${notice.regDate}</h3>
	<h3>조회수 : ${notice.hit}</h3>
	
	<a href="./list">List</a>
	<a href="./delete?num=${notice.num}">Delete</a>
	<a href="./update?num=${notice.num}">Update</a>
</body>
</html>