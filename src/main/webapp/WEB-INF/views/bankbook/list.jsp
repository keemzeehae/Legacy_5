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
	<h1> Bankbook list page</h1>
	<h1>${list}</h1>
	
	<!-- bookName booRate bookSale -->
	<table>
		<thead>
			<tr>
				<th>BookName</th><th>BookRate</th><th>BookSale</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="book">
			<tr>
				<td><a href="./detail?bookNumber=${pageScope.book.bookNumber}">${pageScope.book.bookName}</a></td>
				<td>${pageScope.book.bookRate}</td>
				<td>${pageScope.book.bookSale}</td>
				<td></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="./add">add</a>


</body>
</html>