<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "contextPath" value = "<%= request.getContextPath() %>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src = "${contextPath}/js/sockjs.js"></script>
	<script type="text/javascript" src = "${contextPath}/js/stomp.js"></script>
	<script type="text/javascript">
		var sock;
		function connect() {
			alert("ddddd");
			
			//contextPath
			sock = new SockJS("${contextPath}/chat");
			//sock = new SockJS("http://localhost:8082/Day0711_WebSocket/chat");
			//sock으로 연결하는게 아니라 sockjs 기반 stomp를 이용해서 연결
			stompClient = Stomp.over(sock);
			stompClient.connect({},function() {
				//서버로부터 메시지가 들어오면 처리한다. 특정 url 메시지에 대해 구독!
				//서버가 해당 url로 메시지를 보내면 메시지를 처리
				//stompClient.subscribe(url, function);
				stompClient.subscribe("/topic/msg/${param.memberid}",function(message){
					
					console.log("Message : " + message);
					
					//message에 온갖 것들이 다 붙어있어서 body인 채팅내용만 가져오자
					var data = JSON.parse(message.body);
					
					//alert(message);
					console.log("Message.body : " + data);
					console.log("data.body : " + data.body);
					addMessage(data.body);
				});
			});
		};
		function sendMessage(msgText){
			//메시지 보내기
			//   /client/greeting
			var targetid = $("#targetUser").val();
			stompClient.send("/client/greeting/${param.memberid}/"+targetid,{},msgText);
		};
		function addMessage(data) {
			var allChat = $("#chatArea");
			allChat.append(data+"\n");
		}
		
		$(function(){
			connect();
			$("#btn_send").on("click",function(){
				var chatMsg = $("#chatMsg").val();
				sendMessage(chatMsg);
				$("#chatMsg").val("");
				addMessage(chatMsg);
			});
		});
	
	
	</script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Stomp</title>
</head>
<body>
	<!-- 1. 웹소켓 연결 요청
	     2. 메시 전달
	     3. 메시지 수신
	 -->
	<form action="" id="chatForm">
	 접속자 id : ${param.memberid}<br>
		<textarea rows="20" cols="30" style="display: block" id="chatArea"></textarea>	 
		메시지 : <input type="text" id="chatMsg" align="middle">
		받는이 : <input type="text" id="targetUser">
		<input type="button" value="전송" id="btn_send" align="middle">
	</form>
</body>
</html>