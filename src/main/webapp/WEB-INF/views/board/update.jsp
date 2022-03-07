<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} update page</h1>
	<h1>글수정하기</h1>
	<form action="./update" method="post">
		<input type="hidden" name="num" value="${dto.num}" readonly="readonly">
		글제목 <input type="text" name="title" value="${dto.title}">
		<div>
			글내용
			<textarea name="contents" rows="50" cols="50">${dto.contents}</textarea>
		</div>

		작성자 <input readonly="readonly" readtype="text" name="writer" value="${dto.writer}"> 
		<input type="submit" name="update">
		<button type="button">UPDATE</button>
	</form>
</body>
</html>