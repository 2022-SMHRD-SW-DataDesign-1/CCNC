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
			<form action="JoinService.jsp" method="post">
				<li><input type="text" name="usernumber" placeholder="사업자등록번호를 입력하세요" id="inputE"></li>
				<li><input type="button" value="사업자등록번호중복체크" onclick="checkE()"></li>
				<li><span id="resultCheckE"></span></li>
				<li><input type="password" name="pw" placeholder="PW를 입력하세요"></li>
				<li><input type="image" name="registration" placeholder="등록해주세요" id="registration"></li>
				
				
				<li><input type="submit"  value="회원가입완료" 
					class="button fit"></li>
			</form>
</body>
</html>