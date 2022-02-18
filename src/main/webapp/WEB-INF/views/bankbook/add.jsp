<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook add page</h1>
	
	<h1>상품추가</h1>
		<form action="./add" method="POST">
			BookName<input type="text" name="bookName">
			BookContents<textarea name="bookContents" rows="10" cols="50"></textarea>
			BookRate<input type="number" step="0.01" name="bookRate">
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