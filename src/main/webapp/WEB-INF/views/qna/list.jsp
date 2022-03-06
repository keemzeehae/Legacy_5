<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./../template/header_css.jsp"></c:import>
</head>
<body>
<c:import url="./../template/header.jsp"></c:import>
	<h1>Qna List</h1>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Contents</th>
				<th>writer</th>
				<th>Date</th>
				<th>Hit</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="qna">
				<tr>
					<td><a href="./detail?num=${qna.num}">${qna.title}</a></td>
					<td>${qna.contents}</td>
					<td>${qna.writer }</td>
					<td>${qna.regDate }</td>
					<td>${qna.hit}</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>
	<a href="./add">ADD</a>
</body>
</html>