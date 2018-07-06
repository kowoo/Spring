<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% request.setAttribute("contextPath", request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시판 목록</title>
	<script
	  src="https://code.jquery.com/jquery-3.3.1.min.js"
	  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	  crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(function(){
			loadList();
		});
		function loadList() {
			$("#boardTable tr:gt(0)").remove();
			var table = $("#boardTable");
			$.ajax({
				url : "${contextPath}/board/list",
				type : "get",
				dataType : "json",
				success : function(data){
					$(data).each(function(){
						var tr = $("<tr>");
						var btn = $("<input type='button' value='x'>");
						var num = this.num;
						var title = this.title;
						var name = this.name;
						var readCount =this.readCount;
						var date = new Date(this.writeDate);
						var y = date.getFullYear();
						var m = date.getMonth()+1;
						var d = date.getDate();
						
						$("<td align='center'>").text(num).appendTo(tr);
						$("<td>").text(title).appendTo(tr);
						$("<td align='center'>").text(name).appendTo(tr);
						$("<td align='center'>").text(m+"월"+d+"일").appendTo(tr);
						$("<td align='center'>").text(readCount).appendTo(tr);
						tr.appendTo(table);
					});
				}
			});
		}
	</script>

</head>
<body>
	<div id="wrap" align="center">
		<table class="list" id="boardTable">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
<%-- 			<c:forEach items="${boardList}" var="board"> --%>
<!-- 				<tr> -->
<%-- 					<td>${board.num}</td> --%>
<%-- 					<td class="title"><a href="board?command=board_view&num=${board.num}">${board.title}</a></td> --%>
<%-- 					<td>${board.name}</td> --%>
<%-- 					<td>${board.writeDate}</td> --%>
<%-- 					<td>${board.readCount}</td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
		</table>	
		<a href="write">게시글 등록</a>
	</div>
</body>
</html>