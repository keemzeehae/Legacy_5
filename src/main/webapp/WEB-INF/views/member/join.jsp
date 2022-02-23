<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	<form action="./join" method="post">
		<fieldset>
			<legend>ID</legend>
			<input type="text" name="id">
		</fieldset>

		<fieldset>
			<legend>PW</legend>
			<input type="password" name="pw">
		</fieldset>

		<fieldset>
			<legend>이름</legend>
			<input type="text" name="name">
		</fieldset>

		<fieldset>
			<legend>전화번호</legend>
			<input type="text" name="phone">
		</fieldset>

		<fieldset>
			<legend>이메일</legend>
			<input type="text" name="email">
		</fieldset>

		<fieldset>
			<button type="submit">Join</button>
		</fieldset>

		


	</form>
</body>
</html>