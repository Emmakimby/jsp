<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="survey.*"%>
<%
request.setCharacterEncoding("UTF-8");
Pet_TypeDao Tdao = Pet_TypeDao.getInstance();
Pet_InfoDao pdao = Pet_InfoDao.getInstance();
%>
<jsp:useBean id="Tdto" class="survey.Pet_TypeDto" />
<jsp:setProperty name="Tdto" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반려동물의 정보 입력</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/loginstyle.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
<style>
h3 {
	text-align: center;
}

h4 {
	text-align: center;
}
</style>
<jsp:useBean id="dto" class="survey.Pet_InfoDto" />
<jsp:setProperty name="dto" property="*" />
</head>
<body>
	<section>
		<article class="petinfo">
			<form name="petinfo" method="post" action="#">
				<h3>설문조사</h3>
				=========================<br> 
				5. 반려동물의 이름을 입력해주세요.<br> <br>
				이름 : <input type="text" name="name" required /> <br> <br>
				6. 반려동물의 나이를 입력해주세요.<br> <br> 
				나이 : <input type="text" name="Petage" required /> <br> <br>
				=========================
				<h4>현재 다른 반려동물도 키우고 계시나요?</h4>
				<input type="radio" name="Pet" value="Y">Y. 네 키우고 있습니다.<br>
				<input type="radio" name="Pet" value="N">N. 아니요, 현재 키우고 있지
				않습니다.<br> <br> <br> 
				
				
				
				<% String age = request.getParameter("age");
				String House = request.getParameter("House");
				String Pet = request.getParameter("Pet");
				String type1 = request.getParameter("type");
				%>
				<input type="hidden" name="petNum" value="<%=type1 %>">
				<input type="hidden" name="age" value="<%=age %>">
				<input type="hidden" name="House" value="<%=House %>">
				<input type="hidden" name="Pet" value="<%=Pet %>">
				<input type="submit" value="전송" onclick='getpet2()'>
			</form>
		</article>
	</section>
</body>
</html>