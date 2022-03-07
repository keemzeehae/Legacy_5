<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<h1 class="title"> Bankbook list page</h1>
	<!--검색창-->	
	<div>
		<form action="./list" method="get">
			<fieldset>
				<select name="kind">
					<option value="col1">제목</option>
					<option value="col2">본문</option>
					<option value="col3">작성자</option>
				</select>
				<input type="text" name="search" value="${pager.search}">
				<button type="submit">검색</button>
			</fieldset>
		</form>
	</div>


	<!-- bookName booRate bookSale -->
		<table class="table-basic">
			<thead>
				<tr>
					<th>상품번호</th>
					<th>BookName</th>
					<th>BookRate</th>
					<th>BookSale</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="book">
				<tr>
					<td>${pageScope.book.bookNumber}</td>
					<td><a href="./detail?bookNumber=${pageScope.book.bookNumber}">${pageScope.book.bookName}</a></td>
					<td>${pageScope.book.bookRate}</td>
					<td>${pageScope.book.bookSale}</td>
					<td></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	
	<div>
	
		<c:if test="${pager.pre}">
			<a href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">PREVIEW</a>
		</c:if>
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
		<!-- 여기서 ?뒤에 page가 파라미터고 그 파라미터의 값이 ${i}라고 이해해야함 -->
			<a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
		</c:forEach>
		<c:if test="${pager.next}">
			<a href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">NEXT</a>
		</c:if>
	</div>
	<a href="./add">add</a>
</div>

</body>
</html>