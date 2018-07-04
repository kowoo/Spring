<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원몪롞</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	/*
	   비동기 방식으로 요청/처리 하기
	  1.아이디 확인
	  2.회원가입 후 회원 목록가져오기	
	*/
	$(function(){
		$("#userid").on("blur",function(){
			$.ajax({
				url:"member?command=checkId",
				data: {"userid":$(this).val()},
				dataType : "json",
				success : function(data){
					if(data.result){
						$("#idDup").html("<small>사용가능아이디</small>");
					}else{
						$("#idDup").html("<small>사용불가아이디</small>");
					}
				},
				error : function(){
					alert("실패");
				}
				
			});
		});
		$("#email").on("blur",function(){
			$.ajax({
				url:"member?command=checkEmail",
				data: {"email":$(this).val()},
				dataType : "json",
				success : function(data){
					if(data.result){
						$("#emailDup").html("<small>사용가능이메일</small>");
					}else{
						$("#emailDup").html("<small>사용불가이메일</small>");
					}
				}
				
			});
		});
		$("#joinForm").on("submit",function(){
			var d = $(this).serialize();
			$.ajax({
				url:"member?command=join",
				data:d,
				type:"post",
				dataType : "json",
				success : function(data){
					if(data.result){
						alert("회원가입성공");
						createList();
					}else{
						alert("회원가입실패");
					}
				}
			});
			return false;
		});
		//memberList 요청이 들어오면 회원목록을json 
		//형태로 만들어서 반환
		createList();
	});
	function createList() {
		//list table에 회원 목록을 조회해서 출력하는 함수
		//ajax 요청
		//반환된 데이터를 tr, td요소를 만들어서 갖다붙인다
		var table = $("#listTable");
		
		$("#listTable tr:gt(0)").remove();
		
		$.ajax({
			url:"member?command=memberList",
			type:'get',
			dataType: "json",
			success : function(data){
				//멤버리스트가 가지고 있는 json객체
				//alert(data);
				for (var i in data) {
					//반복문 반복 하면서 데이터를 테이블에 추가하기
					//테이블에 tr추가
					//tr, td 추가
					var tr = $("<tr>");
					var btn = $("<input type='button' value='x'>");
					$("<td>").text(data[i].id).appendTo(tr);
					$("<td>").text(data[i].email).appendTo(tr);
					$("<td>").text(data[i].name).appendTo(tr);
					$("<td>").append(btn).appendTo(tr); // appendTo는 부모요소에 자식요소를 집어넣는것, append는 자식요소를 추가하는것
					//$('<button onclick="delBtn();">삭제</button>').appendTo(tr); //밸류에 넣지말자....
					tr.appendTo(table);
					
					//이렇게 작성하면 뭘하던지 계속 마지막 녀석만 선택됨. 첫번째 삭제버튼 눌러도 마지막 id가 나와버려
					//왜 이렇게 되냐면 data[i]의 i가 하나의 변수로 저장이 되어버렸기 때문이다.
					//삭제 function은 작성 당시에는 i가 계속 변하고 있지만
					//실제로는 클릭을 할 때 작동을 하기 때문에 저장된 i는 최종값인 마지막 녀석이 되어버림.
					//이걸 방지하기 위해서 즉시 실행함수로 만들어주자.
					(function(m) {
						btn.on("click",function() {
							$.ajax({
								url:"member?command=delete",
								data: {"id":data[m].id},
								type: "post",
								dataType: "json",
								success: function(data) {
									alert(data.result);
									createList();
								}
							});
							
						});
					})(i);
					

				}
			}
		});
	}
// 	function delBtn() {
// 		$.ajax({
// 			url:"member?command=delete",
// 			data: this.val(),
// 			type:'post',
// 			dataType:'json',
// 			success: function(data) {
// 				if(data.result){
// 					alert("삭제성공");
// 				}else{
// 					alert("삭제실패");
// 				}
// 			}
// 		});
// 	}
	
</script>
<style type="text/css">
	table, tr, td, th{
		border: 1px solid gray;
		border-collapse: collapse;
		padding: 10px;
	}
	span{
	}
	input{
		border:none;
	}
	th{
		background-color:black;
		color:white;
	}
</style>
</head>
<body>
	<form name="joinForm" method="post" id=joinForm>
		<table border="1">
			<tr bgcolor="gray">
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
			<tr>
				<td><input type="text" name="userid" id="userid"><span
					id="idDup">아이디중복여부</span></td>
				<td><input type="password" name="password" id="password"></td>
				<td><input type="text" name="name" id="name"></td>
				<td><input type="text" name="email" id="email"><span
					id="emailDup">이메일중복여부</span></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="가입하기" id="joinBtn"></td>
			</tr>
		</table>
	</form>
	<h2>회원 목록</h2>
	<table id="listTable" border="1">
		<colgroup>
			<col width="150px">
			<col width="250px">
			<col width="100px">
		</colgroup>
		<tr bgcolor="gray">
			<th>아이디</th>
			<th>이메일</th>
			<th>이름</th>
		</tr>
	</table>
</body>
</html>
