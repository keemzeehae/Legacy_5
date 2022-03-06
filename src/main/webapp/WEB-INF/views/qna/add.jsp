<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Qna ADD</h1>
	<form action="./add" method="post">
		Title<input type="text" name="title">
		Contents<textarea rows="30" cols="30" name="contents"></textarea>
		Writer<input type="text" name="writer">
		<input type="submit" value="ADD">
		<button type="button">ADD</button>
	</form>
</body>
</html>