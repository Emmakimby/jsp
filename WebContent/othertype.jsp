<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import = "survey.*" %>
<%
Pet_TypeDao dao = Pet_TypeDao.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
<title>다른 타입의 종 입력하기</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/loginstyle.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
<style>
h3 {
	text-align: center;
}
</style>
<jsp:useBean id="dto" class="survey.Pet_TypeDto" />
<jsp:setProperty name="dto" property="*" />
</head>
<body>
<section>
		<article class="othtype">
			<form name = "othtype" method="post" action="#">
<h3>설문조사</h3>
=========================<br>
<input type="hidden" name="age" value="<%=request.getParameter("age")%>">
				<input type="hidden" name="House" value="<%=request.getParameter("House") %>">
				<input type="hidden" name="Pet" value="<%=request.getParameter("Pet")%>">
현재 키우고 있는 반려동물의 종을 입력해주세요.
<br><br>
입력 란 : <input type="text" name="typename" required />
<br><br><input type="submit" value="전송" onclick='gettype2()'>
</form>
</article>
</section>
</body>
</html>