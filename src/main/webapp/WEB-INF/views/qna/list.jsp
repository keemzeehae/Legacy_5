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
		<h1 class="title">Qna List</h1>
		<div>
			<form action="./list" method="get">
				<fieldset>
					<select name="kind">
						<option value="writer">작성자</option>
						<option value="title">제목</option>
						<option value="contents">내용</option>
					</select> <input type="text" name="search" value="${pager.search}">
					<button type="submit">검색</button>
				</fieldset>
			</form>
		</div>

		<table class="table-basic">
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
		<div>
			<c:if test="${pager.pre}">
				<a href="./list?page=${pager.startNum-1}">PREVIEW</a>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
				<a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
			</c:forEach>
			<c:if test="${pager.next}">
				<a href="./list?page=${pager.lastNum+1}">NEXT</a>
			</c:if>
		</div>
		<a href="./add">ADD</a>
	</div>
</body>
</html>