<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setAttribute("contextPath", request.getContextPath()); %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
  <script type="text/javascript">
	$(function(){
		loadList();
		$("#signForm").on("submit",function() {
			var name = $("#name").val();
			var gender = $("#gender").val();
			var age = $("#age").val();
			$.ajax({
				url: "${contextPath}/member/add",
				type: "post",
				data: {name : name,
					   gender : gender,
					   age : age
				},
				dataType: "json",
				success: function(data) {
					if(result) {
						alert("등록 성공~");
					}else {
						alert("등록 실패!");
					}
						loadList();
				}
			});
		});
		function loadList() {
			var list = $("#members");
			list.html("");
			$.ajax({
				url: "${contextPath}/member/list",
				type: "get",
				dataType: "json",
				success: function(data) {
					$(data).each(function() {
						var li = $("<li>");
						var btn = $("<input type = 'button' value ='수정'>");
						var name = this.name;
						var gender = this.gender;
						var age = this.age;
						var num = this.num;
						
						li.text(name+" // "+gender+" // "+age);
						li.attr("num",num);
						btn.appendTo(li);
						li.appendTo(list);
					});
				}
			});
			return false;
		}
	
	});
  </script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 목록</title>
</head>
<body>
	<form action="" id="signForm">
		이름 <input type="text" name="name" id="name"><br>
		성별 <input type="text" name="gender" id="gender"><br>
		나이 <input type="text" name="age" id="age"><br>
		<br>
		<input type="submit" value="가입">
	</form>
	<ul id="members">
	
	</ul>
</body>
</html>