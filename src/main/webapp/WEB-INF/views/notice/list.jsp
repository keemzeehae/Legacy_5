<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./../template/header_css.jsp"></c:import>
</head>
<body>
<c:import url="./../template/header.jsp"></c:import>
	<h1>Notice List page</h1>
	<h1>${list}</h1>
	<table>
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
			<c:forEach items="${list}" var="notice">
				<tr>
					<td><a href="./detail?num=${pageScope.notice.num}">${pageScope.notice.title}</a></td>
					<td>${pageScope.notice.contents}</td>
					<td>${pageScope.notice.writer}</td>
					<td>${pageScope.notice.regDate}</td>
					<td>${pageScope.notice.hit}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>
	<a href="./add">add</a>

</body>
</html>