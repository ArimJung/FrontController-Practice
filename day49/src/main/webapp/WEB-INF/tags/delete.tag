<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="bmid" %>
<%@ attribute name="bid" %> <!-- el식에 쓸 변수 -->

<c:choose> 
	<c:when test="${mid == bmid}">
		<form action="deleteB.do" method="post">
			<input type="hidden" name="bid" value="${bid}">
			<input type="submit" value="삭제하기">
		</form>
	</c:when>
</c:choose>