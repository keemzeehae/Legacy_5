<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <h1>detail page</h1>
	 <h3>BookName : ${book.bookName }</h3>
	 <h3>BookRate : ${book.bookRate }</h3>
	 <h3>BookSale : ${book.bookSale }</h3>
	 
	 <a href="./list">List</a>
	 <a href="./delete?bookNumber=${book.bookNumber}">Delete</a>
</body>
</html>