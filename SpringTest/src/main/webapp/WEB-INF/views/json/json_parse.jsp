<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 데이터</title>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
	<script type="text/javascript">
		// JSON 형식의 문자열 객체를 선언한다.
		var str = '{"usr_id" : "su", "usr_pw" : "1234", "usr_name" : "홍길동"}'; // 문자열 객체를 JSON 객체로 변환하여 반환한다.
		var data = JSON.parse(str);
		$.ajax({
			url : "./jsonpost",
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			//JSON 객체인 키를 문자열 객체로 변환하여 반환한다.
			data : JSON.stringify(data)
		});
	</script>
</body>
</html>