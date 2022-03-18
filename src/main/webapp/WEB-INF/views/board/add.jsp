<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>

</head>
<body>
	<h1>${board} add page</h1>
	<h1>글작성하기</h1>
	<form action="./add" method="post" enctype="multipart/form-data">
		글제목 <input type="text" name="title">
		<div>
			글내용
			<textarea name="contents" rows="20" cols="20"></textarea>
		</div>
		
		작성자 <input type="text" name="writer" value="${member.id}" readonly="readonly">
		
		<div id="fileResult">

			<!-- <div>
				<input type="file" name="files"><button type="button">DEL</button>
			</div> -->
			
			<!-- 
			<input type="file" name="files">
			<input type="file" name="files"> -->
		</div>
		<div>
			<button type="button" id="fileAdd">FileAdd</button>
			<button type="button" class="del">Sample DEL</button>
		</div>
		 
		<input type="submit" name="ADD">
		<button type="button">ADD</button>
	</form>
	<script src="../resources/js/file.js"></script>
</body>
</html>