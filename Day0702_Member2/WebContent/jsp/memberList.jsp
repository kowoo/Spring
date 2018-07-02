<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원목록</title>
<style type="text/css">
	table{
		margin: 0 auto;
		margin-top: 20px;
		text-align: center;
	}
	
</style>
</head>
<body>
	<h2 align="center">리스트</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>성별</th>
			<th>이름</th>
			<th>가입일</th>
		</tr>
		<c:forEach items="${memberList}" var="m">
			<tr>
				<td>${m.id}</td>
				<td>${m.name}</td>
				<td>${m.email}</td>
				<td>${m.regDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>