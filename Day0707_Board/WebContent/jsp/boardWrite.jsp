<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>새 글 작성</title>
	<script
		src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
	</script>
 	<style type="text/css">
		div, form, table{
			margin: 0 auto;
		}
		div{
			text-align: center;
		}
		th{
			margin: 0px;
			width: 150px;
		}
		tr{
			text-align: left;
			margin-bottom: 15px;
		}
		textarea{
			width: 95%;
			height: 200px;
		}
		table{
			border: 1px solid black;
			width: 600px;
		}
	</style>
	<script type="text/javascript">
		$(function() {
			//1번 방법
//			var name = $('#name')
//			var nameError = $('#nameError')
// 			$("#name").blur(function(){
// 				if($(this).val()=="") {
// 					$('#nameError').html('필수입력!!');
// 				}else {
// 					$('#nameError').html('');
// 				}
// 			});
// 			$("#pass").blur(function(){
// 				if($(this).val()=="") {
// 					$('#passError').html('필수입력!!');
// 				}else {
// 					$('#passError').html('');
// 				}
// 			});
// 			$("#email").blur(function(){
// 				if($(this).val()=="") {
// 					$('#emailError').html('필수입력!!');
// 				}else {
// 					$('#emailError').html('');
// 				}
// 			});
// 			$("#title").blur(function(){
// 				if($(this).val()=="") {
// 					$('#titleError').html('필수입력!!');
// 				}else {
// 					$('#titleError').html('');
// 				}
// 			});
			
			//2번 방법
			$(".input").blur(function(){
				if(($(this).val())=="") {
					$(this).siblings().text('필수입력 항목입니다.');
 				}
			});
			$("#email").blur(function(){
				var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
				if(($("#email").val())!="" && !regExp.test($("#email").val())) {
					$("#email").siblings().text('이메일 양식을 지켜주세요!');
				}
			 return false;
			});
			
		});
	</script>
</head>
<body>
	<!-- 새 글쓰기 양식 작성 -->
	<div class="wrap">
		<h1>게시글 등록</h1>
		<h5>*는 필수입력 항목입니다.</h5>
		<form name="frm" action="write" method="post">
		<table>
			<tr>
				<th>*작성자</th>
				<td><input type="text" id="name" name="name" class="input"><span id="nameError" style="color:red;"></span></td>
			</tr>
			<tr id="">
				<th>*비밀번호</th>
				<td><input type="text" id="pass" name="password" class="input"><span id="passError" style="color:red;"></span></td>
			</tr>
			<tr>
				<th>*이메일</th>
				<td><input type="text" id="email" name="email" class="input"><span class="span" style="color:red;"></span></td>
			</tr>
			<tr>
				<th>*제목</th>
				<td><input type="text" id="title" name="title" class="input"><span id="titleError" style="color:red;"></span></td>
			</tr>
			<tr>
				<th>*내용</th>
				<td><textarea name="content"></textarea></td>
			</tr>
		</table>
		<br>
			<input style="margin-left: 0px" type="submit" value="등록">
			<input style="margin-left: 50px" type="reset" value="다시작성">
			<input style="margin-left: 150px" type="button" value="목록" onclick="location.href='start'">
		</form>
	</div>
</body>
</html>