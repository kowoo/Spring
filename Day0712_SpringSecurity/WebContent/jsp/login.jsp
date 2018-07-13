<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<c:url value="/member/login" var="loginUrl"/>
	<form name="frm" action="${loginUrl}" method="post">
		<!-- 스프링 시큐리티로 로그인 요청을 할 때 꼭 있어야함 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<fieldset>
			<legend>Please Login</legend>
			<label for="username">사용자 이름 : </label> <input type="text" id="username" name="username" value="${username}">
			<label for="password">비밀번호 : </label> <input type="password" id="password" name="password">
			<div>
				<input type="submit" value="Login">
			</div>
		</fieldset>
	</form>
</body>
</html>