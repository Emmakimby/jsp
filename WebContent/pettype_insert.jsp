<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="survey.*"%>
<%
request.setCharacterEncoding("UTF-8");
Pet_TypeDao Tdao = Pet_TypeDao.getInstance();
%>
<jsp:useBean id="Tdto" class="survey.Pet_TypeDto" />
<jsp:setProperty name="Tdto" property="*" />


<%
	String name = request.getParameter("typename");

boolean ret = Tdao.insertPet_Type(name);
%>

	<input type="hidden" name="age" value="<%=request.getParameter("age")%>">
				<input type="hidden" name="House" value="<%=request.getParameter("House")%>">
				<input type="hidden" name="Pet" value="<%=request.getParameter("Pet")%>">
<jsp:forward page="Pet_TypeMain.jsp" />