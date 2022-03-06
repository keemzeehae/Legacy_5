<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Qna Update</h1>
	<form action="./update" method="post">
		<input type="hidden" readonly="readonly" name="num" value="${dto.num}">
		Title <input type="text" name="title" value="${dto.title}">
		Contents <textarea rows="30" cols="30" name="contents">${dto.contents}</textarea>
		Writer <input name="writer" value="${dto.writer}" readonly="readonly">
		Date <input name="regDate" value="${dto.regDate}" readonly="readonly">
		Hit <input name="hit" value="${dto.hit}" readonly="readonly">
		
		<input type="submit" value="ADD">
		<button type="button">ADD</button>
	</form>
</body>
</html>