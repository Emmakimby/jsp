<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page import="survey.*"%>

<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 대상자 정보 입력</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/loginstyle.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
<style>
h3 {
	text-align: center;
}
</style>
<jsp:useBean id="Mdto" class="survey.Man_InfoDto" />
<jsp:setProperty name="Mdto" property="*" />
</head>
<body>
	<section>
		<article class="maninfo">
			<form name="Maninfo" method="post" action="#">

				<h3>설문조사</h3>
				=========================<br>설문조사를 진행하겠습니다.<br> <br>
				1. 본인의 나이는 몇 살입니까? <br>
				<숫자로 입력해주세요.> <br>
				<br>
				나이 : <input type="text" name="age" required /> <br>
				<br>
				2. 가구 인원(본인 포함) 수는 어떻게 되시나요? <br>
				<br>

				<input type="radio" name="House" value="1">1인 가구<br>
				<input type="radio" name="House" value="2">2인 가구<br>
				<input type="radio" name="House" value="3">3인 가구<br>
				<input type="radio" name="House" value="4">4인 가구<br>
				<input type="radio" name="House" value="5">5인 가구 이상<br>
				<br>
				3. 현재 반려동물을 키우고 계시나요?<br>
				<br>
				<input type="radio" name="Pet" value="Y">Y. 네 키우고 있습니다.<br>
				<input type="radio" name="Pet" value="N">N. 아니요, 현재 키우고 있지
				않습니다.<br>
				<br>
				<br>
				<input type="submit" value="전송" onclick='getpet()'>
				
			</form>
		</article>

	</section>

</body>
</html>