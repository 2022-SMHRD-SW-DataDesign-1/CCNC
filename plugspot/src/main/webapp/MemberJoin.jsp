<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<li><h5>회원가입</h5></li>
	<form action="./JoinService" method="post" enctype="multipart/form-data">
		<li><input type="text" name="member_num" id="inputE" placeholder="사업자등록번호를 입력하세요"></li>
		<li><input type="button" value="사업자등록번호중복체크" onclick="checkE()"></li>
		<li><span id="resultCheckE"></span></li>
		<li><input type="text" name="password" id="pw" placeholder="PW를 입력하세요"></li>
		<li><input type="text" name="member_type" placeholder="누가 되고싶니?"></li>
		<li><input type="file" name="filename" id="filename" placeholder="등록하기"></li>
		<li><input type="submit" value="회원가입완료" class="button fit"></li>
	</form>
	 	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>
	 <script>
	
		function checkE() {
			let inputE = $('#inputE').val();
			console.log(inputE);

			$.ajax({
				url : 'numCheck',
				data : {'inputE' : inputE },
				type : 'get',
				success : function(data) {
					console.log(data);

					if (data == true) {
						$("#resultCheckE").text("사용 불가해 이자식아.");
					} else {
						$("#resultCheckE").text("사용해 이자식아.");
					}
				},
				error : function() {
					console.log("통신실패");
				}
			});
		}
	</script>
</body>
</html>