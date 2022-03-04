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
	<form action="./join" method="post" id="frm">
		<fieldset>
			<legend>ID</legend>
			<input type="text" name="id" id="id">
			<div id="idResult"></div>
		</fieldset>

		<fieldset>
			<legend>PW</legend>
			<input type="password" name="pw" id="pw" placeholder="8글자 이상 12글자 이하로 작성하세요.">
			<div id="pwResult"></div>
		</fieldset>

		<fieldset>
			<legend>PW 확인</legend>
			<input type="password" name="pw2" id="pw2">
			<div id="pwResult2"></div>
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
			<button type="button" id="btn">Join</button>
		</fieldset>

		
		<script src="../resources/js/join.js"></script>

	</form>
</body>
</html>