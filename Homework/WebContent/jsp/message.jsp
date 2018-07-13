<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메시지</title>
</head>
<body>
	<form action="message" method="post">
		<label>받는사람:</label><input type="text" id="receiver" name="receiver" value="${receiver}" readonly="readonly"> <br>
		<label>내용:</label><input type="text" id="content" name="content"> <br>
		<input type="submit" value="보내기">
		<input type="button" value="취소" onclick="location.href='main'">
	</form>
</body>
</html>