<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="./template/header_css.jsp"></c:import>
	<script type="text/javascript">

	</script>


</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	<div>
		<img alt="" src="./resources/images/ju.jpg">
	</div>
	<h1>index page</h1>
	<!-- scope명 생략가능 -->
	<h3>${sessionScope.member.name}님환영합니다
		<span class="material-icons-outlined"> account_circle </span>
	</h3>
	<div>
		<c:if test="${not empty member}">
			<a href="./member/mypage">Mypage</a>
			<a href="./member/logout">Logout</a>
		</c:if>
		<c:if test="${empty member}">
			<a href="./member/login">Login</a>
			<a href="./member/join">Join</a>
		</c:if>
	</div>
	<img alt="" src="./resources/upload/member/245e5c42-f24a-4b8b-b067-83eb2543f79f_ari.jpg">

</body>

</html>