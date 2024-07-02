<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 Ajax 요청</title>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/validity.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		// register 아이디를 클릭하여 함수를 호출한다.
		$('#register').click(function() {
			//input 요소의 id 속성값을 탐색하여 속성값을 반환한다.
			var id = $("input[name='id']").val();
			//input 요소의 password 속성값을 탐색하여 속성값을 반환한다.
			var password = $("input[name='password']").val(); // 비동기 Ajax 요청을 수행한다.
			$.ajax({
				url : "./ajaxData",
				type : "GET",
				//GET 메서드 전송 방식으로 데이터를 쿼리 문자열로 설정한다.
				data : "id=" + id + "&password=" + password,
				//응답 바디, 응답 코드, XHR 헤더를 확인할 수 있으며 응답 바디인 결과를 확인한다.
				success : function(result) {
					// 결과를 id 속성값에 전달한다.
					$('#message').html(result);
				}
			});
			//값이 없거나 ""(빈 문자열), 0, NaN, null, undefined의 객체 초기값은 false가 되므로 false로 반환한다.
			return false;
		});
	});
</script>
</head>
<body>
	<div class="container p-3 my-3 border">
		<form>
			<fieldset>
				<div class="form-group row">
					<label for="id" class="ml-sm-4 col-form-label"> 아이디 </label>
					<div class="ml-sm-4">
						<input type="text" name="id" id="id"
							class="form-control form-control-sm">
					</div>
				</div>
				<div class="form-group row">
					<label for="password" class="ml-sm-3 col-form-label"> 비밀번호
					</label>
					<div class="ml-sm-3">
						<input type="password" name="password" id="password"
							class="form-control form-control-sm">
					</div>
				</div>
				<div class="form-group">
					<button type="submit" id="register" class="btn btn-primary btn-sm">
						전송</button>
					<button type="reset" id="cancel" class="btn btn-primary btn-sm">
						취소</button>
				</div>
			</fieldset>
		</form>
	</div>
	<div class="container p-3 my-3 border">
		<div id="message"></div>
	</div>
</body>
</html>
