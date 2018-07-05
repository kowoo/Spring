<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <c:set var="contextPath" value="<%request.getContextPath();%>"/> --%>
<% request.setAttribute("contextPath", request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>덧글 화면</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	//1. 등록
	//2. 목록 출력
	//javascript로 처리 (jQuery, ajax)
	$(function(){
		getReplyList();
		$("#replyForm").on("submit",function(){
			alert("submit 이벤트 발생!!");
			var replyWriter = $("#replyWriter").val();
			var replyContent = $("#replyContent").val();
			//ajax로 요청 처리
			$.ajax({
				url:"${contextPath}/replies",
				type:"post",
				data:{boardNum : boardNum,
					replyWriter : replyWriter,
					replyContent : replyContent
				},
				dataType:"json" ,
				success : function(result){
					if(result){
						alert("등록되었습니다.");
					}else{
						alert("등록 실패하였습니다.");
					}
					getReplyList();
					//목록 새로 그리기..
				}
			});
			return false; //이벤트를 더이상 진행하지 않음
		});
	}); //$(function) end ;
	function getReplyList(){
		//비동기 적으로 화면에 그릴 댓글목록 가져오고
		//가져온 댓글 목록을 이용하여 화면 그리기 
		var replies = $("#replies");
		$.ajax({
			url:"${contextPath}/replies/all/"+boardNum,
			type:"get",
			dataType:"json",
			success : function(data){
				//data의 요소를 가지고 한번씩 반복하면서 function 실행
				//jQuery foreach
// 				{"replyNum":1,"boardNum":41,"replyContent":"댓글입니다. 1","replyWriter":"작성자 1","regDate":1530687094000}
				var str = "";
				
				var btn = $("<input type = 'button' value ='수정'>");
				$(data).each(function(){
					var li = $("<li>");
					var rNum = this.replyNum;
					var bNum = this.boardNum;
					var rContent = this.replyContent;
					var rWriter = this.replyWriter;
					var date = new Date(this.regDate);
					li.text(rNum+"/"+rContent+"/"+rWriter+"/"+date);
					li.appendTo(replies);
					li.appendTo("dddddddd");
					
// 					str += "<li>"+rNum+"/"+rContent+"/"+rWriter+"/"+date+"</li>"
// 					$("#replies").html(str);
				});
			},
			error : function(data){
				alert("에러에요");
			}
		});
	}
	

</script>
</head>
<body>
	<h3>${boardNum}번 게시글 덧글 화면입니다.</h3>
	
	
	<!-- 임의의 게시글 하나의 덧글들을 출력하고 입력할 수 있는 화면을 작성한다.
		ajax로!
	 -->
	<form action="" name="replyForm" id="replyForm">
		이름 : <input type="text" name="replyWriter" id="replyWriter">
		내용 : <input type="text" name="replyContent" id="replyContent">
		<input type="submit" value="등록">
	</form>
	<ul id = "replies">
		
	</ul>
</body>
</html>