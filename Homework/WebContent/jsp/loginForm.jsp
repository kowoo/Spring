<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setAttribute("contextPath", request.getContextPath());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Plz</title>
<style type="text/css">
	table{
		margin : 0 auto;
		border : 1px solid gray;
	}

</style>
</head>
<body>
	<div id="wrap">
		<form action="login" method="post">
			<table>
				<tr>
					<th>아이디 : </th>
					<td><input type="text" id="userid" name="userid"></td>
					<td colspan="2"><input type="submit" value="로그인"></td>
				</tr>
				<tr>
					<th>비밀번호 : </th>
					<td><input type="password" id="password" name="password"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>