<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인</title>
<style type="text/css">
	table{
		margin: 0 auto;
	}
</style>
</head>
<body>
	<h1 align="center">메인</h1>
	<h4 align="center">${userid}님 환영합니다!</h4>
	<table>
		<tr>
			<td><input type="button" value="회원목록보기" onclick="location.href = 'memberList'"></td>
			<td><input type="button" value="회원정보수정" onclick="location.href = 'updateForm'"></td>
			<td><input type="button" value="로그아웃" onclick="location.href = 'logout'"></td>
		</tr>
	</table>
</body>
</html>