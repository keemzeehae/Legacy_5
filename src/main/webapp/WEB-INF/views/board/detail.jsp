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
	<h1>${board} detail page</h1>
	<h3>글제목 : ${dto.title}</h3>
	<h3>내용: ${dto.contents}</h3>
	<h3>작성자 : ${dto.writer}</h3>
	<h3>작성자 : ${dto.regDate}</h3>
	<h3>조회수 : ${dto.hit}</h3>
	
	<div>
		<c:forEach items="${dto.fileDTOs }" var="f">
			<!--<a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a>-->
			<a href="./photoDownload?fileNum=${f.fileNum}">${f.oriName}</a>
		</c:forEach>
	</div>
	
	<hr>
	<div>
		<!-- form태그에 있는 걸 받아오는게 아니라서 form태그 쓸 필요 없음 -->
		<input type="hidden" name="num" value="${dto.num}" id="num">
		<input type="text" readonly="readonly" name="writer" value="${member.id}" id="writer">
		<textarea rows="" cols="" name="contents" id="contents"></textarea>
		<button type="button" id="reply">REPLY</button>
	</div>
	
	<table id="replyResult">
		
	</table>
	
	<a href="./list">List</a>
	<c:if test="${member.id eq dto.writer}">
	<a href="./delete?num=${dto.num}">Delete</a>
	<a href="./update?num=${dto.num}">Update</a>
	</c:if>
	<!-- ne 는 같지 않다면 not equal -->
	<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}">Reply</a>
	</c:if>
	
	<script src="../resources/js/noticeReply.js"></script>
</body>
</html>