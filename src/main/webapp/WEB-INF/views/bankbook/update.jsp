<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Update page</h1>
	
	<h1>상품추가</h1>
		<form action="./update" method="POST">
			<input type="hidden" readonly="readonly" name="bookNumber" value="${dto.bookNumber}">
			BookName<input type="text" name="bookName" value="${dto.bookName}">
			BookContents<textarea name="bookContents" rows="10" cols="50" >${dto.bookContents}</textarea>
			BookRate<input type="number" step="0.01" name="bookRate" value="${dto.bookRate }">
			
			BookSale
			<div>
				판매<input type="radio" name="bookSale" value="1"> 
				판매중지 <input type="radio" name="bookSale" value="0">
			</div>
			
			<div>
			Checkbox
				<input type="checkbox" name="">
				<input type="checkbox" name="">
				<input type="checkbox" name="">
				<input type="checkbox" name="">
				<input type="checkbox" name="">
			</div>
			<input type="submit" value="ADD">
			<button type="button">add</button>
		</form>
</body>
</html>