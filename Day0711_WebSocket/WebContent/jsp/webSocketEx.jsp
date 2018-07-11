<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var = "contextPath" value = "<%= request.getContextPath() %>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src = "${contextPath}/js/sockjs.js"></script>
	<script type="text/javascript">
		//연결, 송신, 수신 모두 스크립트가 처리한다.
		
		var ws;
		
		function connect() {		//endpoint, servlet-context에 등록한 웹소켓 핸들러 매핑값.
			ws = new WebSocket('ws://localhost:8082/Day0711_WebSocket/chat');
								// http로 full path를 작성 ex) ws://localhost:8082/Day0711_WebSocket/chat		
			alert("연결요청");
			ws.onopen = function() {
				//연결될 때 동작하는 함수
				console.log("연결됨");
				register();
			}
			ws.onmessage = function(evt) {
				//메시지를 받을 때 동작하는 함수
				
						//여기에 메시지가 들어가도록 만들자.
				var data = evt.data;
				console.log("메시지 받음");
				console.log("받은 데이터 : " + data);
				addMessage(data);
			}
			ws.onclose = function() {
				//연결이 끊겼을 때 동작하는 함수
				console.log("연결 끊김")
			}
		}
		function register() {
			//서버에 현재 사용중인 사용자 정보 등록
			//로그인하고 session 혹은 request에 속성으로 userid 삽입
			//지금은 로그인 구현을 안했으니 param으로 넘기자.
			var msg = {
					type : "register",
					memberid : "${param.memberid}",
			}
			alert(msg.memberid);
			//그냥 보내면 안됨. JSON형식으로 변환. 
			ws.send(JSON.stringify(msg));
		}
		function send(msg) {
			//입력받은 메시지 전달
			var msg = {
					type : "chat",
					target : $("#targetUser").val(),
					message : msg
			}			
			ws.send(JSON.stringify(msg));
		}
		
		function addMessage(data) {
			var allChat = $("#chatArea");
			allChat.append(data+"\n");
		}
		
		$(function(){
			connect();
			$("#btn_send").on("click", function(){
				var msg = $("#chatMsg").val();
				send(msg);
				//textarea에 메시지 추가
				var allChat = $("#chatArea");
				allChat.append("나 : "+msg+"\n");
// 				allChat = allChat + "<br>" + msg;
// 				$("#chatArea").val();
			});
		});
	
	</script>
	<title>채팅</title>
	<style type="text/css">
		#chatForm{
			width: 600px;
			height: 500px;
			margin: 0 auto;
		}
		
		
	</style>
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