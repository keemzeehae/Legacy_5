<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Reply page</h1>
	<h1>글작성하기</h1>
	<form action="./reply" method="post">
	<input type="hidden" name="num" value="${dto.num}">
		글제목 <input type="text" name="title">
		<div>
			글내용
			<textarea name="contents" rows="50" cols="50"></textarea>
		</div>

		작성자 <input type="text" name="writer"> 
		<input type="submit" name="ADD">
		<button type="button">ADD</button>
	</form>
</body>
</html>