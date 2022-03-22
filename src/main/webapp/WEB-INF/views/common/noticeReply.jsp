<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${noticeReply}" var="dto">
	<tr>
		<td>${dto.contents}</td>
		<td>${dto.writer}</td>
		<c:if test="${dto.writer eq member.id }">
			<td>
				<button class="update" type="button">수정</button>
				<button class="del" type="button" data-num="${dto.replynum}">삭제</button>
			</td>
		</c:if>
	</tr>
</c:forEach>