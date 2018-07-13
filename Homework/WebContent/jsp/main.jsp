<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%request.setAttribute("contextPath", request.getContextPath());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src = "${contextPath}/js/sockjs.js"></script>
	<script type="text/javascript" src = "${contextPath}/js/stomp.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
		div{
			width : 800px;
			margin : 0 auto;
		}
		table{
			float : right;
			border : 1px solid gray;
			width : 100px;
		}
		th{
			border-bottom: 1px solid gray;
		}
		td{
			border-right: 1px solid gray;
			text-align: center;
		}
		.state{
			color : gray;
		}
		
	
	</style>
		<script type="text/javascript">
		var sock;
		function connect() {
			sock = new SockJS("${contextPath}/chat");
			stompClient = Stomp.over(sock);
			stompClient.connect({},function() {
			alert("연결시작");
				stompClient.subscribe("/topic/msg/${param.memberid}",function(message){
					
					console.log("Message : " + message);
					
					//message에 온갖 것들이 다 붙어있어서 body인 채팅내용만 가져오자
					var data = JSON.parse(message.body);
					
					console.log("Message.body : " + data);
					console.log("data.body : " + data.body);
					addMessage(data.body);
				});
				
			});
			
		}
		function sendMessage(content){
			//메시지 보내기
			//   /client/greeting
			var receiver = $("#receiver").val();
			stompClient.send("/client/greeting/${param.memberid}/"+receiver,{},content);
		};
		$(function(){
			connect();
			$("#btn_send").on("click",function(){
				var content = $("#content").val();
				sendMessage(content);
				$("#content").val("");
			});			
		});
		
	</script>
<title>메인</title>
</head>
<body>
	<div>
		<h4>${userid}님 환영ㅋ</h4>
		<input type="button" value="로그아웃" onclick="location.href='logout'">
		
		<table>
			<tr>
				<th colspan="2">사용자 목록</th>
			</tr>
			<tr>
				<th>닉네임</th>
				<th>상태</th>
			</tr>
			<c:forEach items="${memberList}" var="m">
				<tr>
					<td>
						<a href="message?receiver=${m.NAME}">${m.NAME}</a>
					</td>
					<td>
						<label class="state" id="${m.NUM}">●</label>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>