<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<style type="text/css">
	table{
		margin: 0 auto;
	}

</style>
</head>
<body>
	<h1 align="center">회원가입</h1>
	<form action="join">
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
				<th>이름</th>
				<td><input type="text" name="name"/>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"/>
			</tr>
			<tr>
				<td><input type="button" value="뒤로가기" align="middle" onclick="history.go(-1)"/>
				<td><input type="submit" value="가입하기" align="middle"/>
			</tr>
		</table>
	</form>
</body>
</html>