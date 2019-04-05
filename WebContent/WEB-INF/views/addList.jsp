<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/insert">
		<table border="1" width="510">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""></td>
			</tr>	
			<tr>
				<td colspan="4"><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>	
			<tr>
				<td colspan="4"><input type="submit" value="확인"></td>
			</tr>
		</table><br>
	</form>
	<c:forEach items="${list }" var="vo" >
		<table border="1" width="510">
			<tr>
				<td>[${vo.no }]</td>
				<td>${vo.name }</td>
				<td>${vo.reg_date }</td>
				<td><a href="${pageContext.request.contextPath}/deleteform?no=${vo.no}">삭제</a></td>
			</tr>
			<tr>
				<td colspan="4"><pre><c:out value="${vo.content }"></c:out></pre></td>
			</tr>
		</table><br>
	</c:forEach>
	
</body>
</html>