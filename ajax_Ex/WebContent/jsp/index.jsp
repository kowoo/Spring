<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		sendAjax();
	});
	function sendAjax() {
		$.ajax({
			url : "home/rest",
			type : 'POST',
			dataType : 'json',
			data : "asd",
			success : function(data) {
				alert(data.da);
			},
			error : function(data, status, er) {
				alert("error: " + data + " status: " + status + " er:" + er);
			}
		});
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>테스트</title>
</head>
<body>

</body>
</html>