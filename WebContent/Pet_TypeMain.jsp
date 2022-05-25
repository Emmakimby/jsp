<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="survey.*"%>
<%
request.setCharacterEncoding("UTF-8");
Pet_TypeDao dao = Pet_TypeDao.getInstance();
%>
<%
Man_InfoDao Mdao = Man_InfoDao.getInstance();
%>
<jsp:useBean id="Mdto" class="survey.Man_InfoDto" />
<jsp:setProperty name="Mdto" property="*" />
<%
	String age = request.getParameter("age");
String House = request.getParameter("House");
String Pet = request.getParameter("Pet");
boolean flag = Mdao.insertMan_Info(age, House, Pet);
%>


<!DOCTYPE html>
<html>
<head>
<title>반려동물의 종 입력</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/loginstyle.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
<style>
h3 {
	text-align: center;
}
</style>

</head>
<body>
	<section>
		<article class="pettype">
			<form name="pettype" method="post" action="#">
				<h3>설문조사</h3>
				=========================<br> 4. 현재 키우고 있는 반려동물의 종은 어떻게 되십니까?<br>
				<br>
				<%
					List<Pet_TypeDto> list = dao.selsctAll();
				for (Pet_TypeDto i : list) {
				%>
				<%=i%><br>
				<%
					}
				%><br> 0. 기타<br> <br> 선택 : <input type="text"
					name="type" required /> <br> <input type="hidden" name="age"
					value="<%=age%>"> <input type="hidden" name="House"
					value="<%=House%>"> <input type="hidden" name="Pet"
					value="<%=Pet%>"> 
					<input type="submit" value="전송" onclick="gettype()">

			</form>
		</article>
	</section>
</body>
</html>