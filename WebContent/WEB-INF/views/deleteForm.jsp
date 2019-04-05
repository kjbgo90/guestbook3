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
<form method="post" action="${pageContext.request.contextPath}/delete/${param.no}">
	<div>비밀번호
		<input type="password" name="password" value="">
		<input type="hidden" name="no" value="${param.no}">
		<input type="submit" value="확인">
		<a href="${pageContext.request.contextPath}/">메인으로 돌아가기</a>
	</div>
</form>
</body>
</html>