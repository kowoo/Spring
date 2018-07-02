<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<style type="text/css">
	table{
		margin: 0 auto;
	}
</style>
</head>
<body>
	<h1 align="center">로그인</h1>
	<form action="login">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"/>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="password"/>
			</tr>
			<tr>
				<td><input type="submit" value="로그인" align="middle"/>
				<td><input type="button" value="회원가입" onclick="location.href = 'joinForm'" />
			</tr>
		</table>
	</form>
</body>
</html>