<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/board.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- 글 수정 폼 -->
	<div class="wrap">
		<h1>게시글 수정</h1>
		<form name="frm" action="board">
			<input type="hidden" name="command" value="board_modify">
			<input type="hidden" name="num" value="${param.num}">
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" value="${board.name}"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="pass" value="${board.pass}"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="${board.email}"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${board.title}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content">${board.content}</textarea></td>
			</tr>
		</table>
		<br>
			<input style="margin-left: 0px" type="submit" value="등록">
			<input style="margin-left: 250px" type="button" value="목록" onclick="location.href='board?command=board_list'">
		</form>
	</div>
</body>
</html>