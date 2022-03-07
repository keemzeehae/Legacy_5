<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./../template/header_css.jsp"></c:import>
<link href="../resources/css/table.css" rel="stylesheet">
<link href="../resources/css/list.css" rel="stylesheet">
</head>
<body>
	<c:import url="./../template/header.jsp"></c:import>
	<div class="table-container">
		<h1 class="title">${board} List page</h1>
		<table class="table-basic">
			<thead>
				<tr>
					<th>글제목</th>
					<th>내용</th>
					<th>작성자</th>
					<th>작성일자</th>
					<th>조회수</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="board">
					<tr>
						<td><a href="./detail?num=${pageScope.board.num}">${pageScope.board.title}</a></td>
						<td>${pageScope.board.contents}</td>
						<td>${pageScope.board.writer}</td>
						<td>${pageScope.board.regDate}</td>
						<td>${pageScope.board.hit}</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
		<a href="./add">add</a>
	</div>
</body>
</html>