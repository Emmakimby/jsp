<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="survey.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
ResultDao Rdao = ResultDao.getInstance();
%>
<jsp:useBean id="dto" class="survey.ResultDto" />
<jsp:useBean id="adto" class="survey.ResultavgDto" />
<jsp:setProperty name="dto" property="*" />
<!DOCTYPE html>
<html>
<head>
<title>설문조사 결과</title>

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
</head>
<body>
	<section>
		<article class="result">
			<form name="result" method="post" action="#">
				<h3>설문조사 결과</h3>
				=========================<br> 응답자 중 반려동물을 키우고 있는 비율<br> <br>
				전체 인원 :
				<%
 	out.print(Rdao.selsctmAll());
 %><br> 반려인 인원 :
				<%
				out.print(Rdao.selsctmYAll());
 %><br>반려인이 아닌 인원 :
				<%
				out.print(Rdao.selsctmNAll());
 %><br> <br>
				<%
					float Z = Rdao.selsctmYAll();
				float X = Rdao.selsctmAll();
				%>
				반려인의 비율 : <%=	String.format("%.1f%%%n", Z / X * 100)%><br> <br> =========================<br> <br>
				가구원수에 따른 반려동물 유무(반려가구의 비율)<br> <br> 1. 1인 가구 -------- <%=	String.format("%.1f%%%n", Rdao.selsctAll1() / X * 100)%><br>
				2. 2인 가구 -------- <%=	String.format("%.1f%%%n", Rdao.selsctAll2() / X * 100)%><br> 3. 3인 가구 -------- <%=	String.format("%.1f%%%n", Rdao.selsctAll3() / X * 100)%><br> 4. 4인 가구
				-------- <%=String.format("%.1f%%%n", Rdao.selsctAll4() / X * 100)%><br> 5. 5인 가구이상 ----- <%=	String.format("%.1f%%%n", Rdao.selsctAll5() / X * 100)%><br> <br>
				=========================<br> <br> 키우는 반려동물의 종류<br> <br>
				<%
					List<ResultDto> list = Rdao.TypeAll();
				for (ResultDto i : list) {
				%>
				<%=i%><br>
				<%
					}
				%><br> <br> =========================<br> <br>키우는
				반려동물의 종별 평균 나이<br> <br>
				<%
					List<ResultavgDto> listage = Rdao.Typeavg();
				for (ResultavgDto i : listage) {
				%>
				<%=i%><br>
				<%
					}
				%><br> <br> =========================<br> <br>

				<h4>
					설문조사 결과를 끝까지 확인 하셨습니다.<br>첫 페이지로 돌아가시겠습니까?
				</h4>
				<input type="radio" name="end" value="info">네, 첫페이지로
				돌아가겠습니다.<br> <input type="radio" name="end" value="end">아니요,
				설문을 종료하겠습니다.<br> <br> <br> <input type="submit"
					value="전송" onclick='getend()'>
			</form>
		</article>
	</section>
</body>
</html>