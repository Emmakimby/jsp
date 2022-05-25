<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="survey.*"%>
<%
request.setCharacterEncoding("UTF-8");
Pet_InfoDao Pdao = Pet_InfoDao.getInstance();
%>
<jsp:useBean id="Pdto" class="survey.Pet_InfoDto" />
<jsp:setProperty name="Pdto" property="*" />

<% String age = request.getParameter("age");
String House = request.getParameter("House");
String Pet = request.getParameter("Pet");
String name = request.getParameter("name");
String Petage = request.getParameter("Petage");

String type1 = request.getParameter("petNum");
%>
<%

int manNum = Pdao.manNum();
System.out.println(manNum + type1+ name+ Petage);
	boolean ret = Pdao.insertPet_Info(manNum, type1, name, Petage);
	
%>
<jsp:forward page="info.jsp"/>