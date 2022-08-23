<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script type="text/javascript">
	function signUp(){
		window.open("signUp.jsp","회원가입 페이지","width=500,height=200");
	}
</script>
</head>
<body>

	<div id="header">
		<h1>비비</h1>
		
		<div class="gnb">
			<ul>
				<li><a href="main.do">메인으로</a></li>
				<li><a href="javascript:signUp()">회원가입</a></li>
				<my:login/>
			</ul>
		</div>
	</div>
	
	<div id="wrapper">
	
		<h2>글 등록하기</h2>
			<my:writer type="msg"/>
		<hr>
		<div id="main">
			<h2>글 목록보기</h2>
			<c:forEach var="v" items="${datas}">
				<c:set var="b" value="${v.boardVO}" />
				[${b.mid}] ${b.msg} [ 좋아요 ${b.favcnt} | 댓글 ${b.rcnt} ] <br>
			
				<!-- 삭제하기 -->
				<my:delete bmid="${b.mid}" bid="${b.bid}" />
				
				<!-- 좋아요 -->	
				<c:choose> 
				<c:when test="${mid != null}">
				<form action="fav.do" method="post">
					<input type="hidden" name="bid" value="${b.bid}">
					<input type="submit" value="좋아요">
				</form>
				</c:when>
				</c:choose>
				
				<div class="reply">
					<ul>
						<c:forEach var="r" items="${v.rList}">
							<li>[${r.mid}] ${r.rmsg}</li>
						</c:forEach>
					</ul>
				</div>
			
			<div class="reply">
				<my:writer type="rmsg" bid="${b.bid}"/>
			</div>
			</c:forEach>
		</div>
		<br>
		<a href="main.do?cnt=${cnt+2}">더보기&gt;&gt;</a>
		<!-- 첫번째 파라미터는 ? (물음표) -->
	</div>
	<br><br><br>	
	<div id="footer">
		회사소개 | 이용약관 | <strong>개인정보처리방침</strong> | 보호정책 | 고객센터 <strong>ⓒ Corp.</strong>
	</div>

</body>
</html>