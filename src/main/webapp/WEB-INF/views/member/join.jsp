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
	<form action="./join" method="post" id="frm"
		enctype="multipart/form-data">
		<fieldset>
			<legend>ID</legend>
			<input type="text" name="id" id="id">
			<div id="idResult"></div>
		</fieldset>

		<fieldset>
			<legend>PW</legend>
			<input type="password" name="pw" id="pw"
				placeholder="8글자 이상 12글자 이하로 작성하세요.">
			<div id="pwResult"></div>
		</fieldset>

		<fieldset>
			<legend>PW 확인</legend>
			<input type="password" name="pw2" id="pw2">
			<div id="pwResult2"></div>
		</fieldset>

		<fieldset>
			<legend>이름</legend>
			<input type="text" name="name" id="name">
		</fieldset>

		<fieldset>
			<legend>전화번호</legend>
			<input type="text" name="phone" id="phone">
		</fieldset>

		<fieldset>
			<legend>이메일</legend>
			<input type="text" name="email" id="email">
		</fieldset>

		<fieldset>
			<legend>사진추가</legend>
			<input type="file" name="photo" id="photo">
		</fieldset>
		
		<fieldset>
			<!-- 최종 완성시 사용<button type="button" id="btn">Join</button>-->
			<button type="submit" id="btn">Join</button>
		</fieldset>


		<!-- <script type="text/javascript" scr="../resources/js/join2.js"></script> -->

	</form>
</body>
</html>