<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${noticeReply}" var="dto" varStatus="i">
	<tr>
		<%-- <td id="up${i.index}">${dto.contents}</td> --%>
		<td id="up${dto.replynum}">${dto.contents}</td>
		<td>${dto.writer}</td>
		<td>
				<c:if test="${dto.writer eq member.id }">
				<%-- <button class="update" type="button" data-index="${i.index}">수정</button> --%>
				<!-- data-index 명칭 바꿔줘도 상관없음 data-num 이런식으로  -->
				<button class="update" type="button" data-index="${dto.replynum}">수정</button>
				<button class="del" type="button" data-num="${dto.replynum}">삭제</button>
			</c:if>
			</td>
	</tr>
</c:forEach>