<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 시작 페이지</title>
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
		<article class="maninfo">
			<form name = "info" method="post" action="#">

				<h3>설문조사</h3>
				=========================<br> 메뉴를 선택하세요.<br>
				<br>
				<input type="radio" name="menu" value="1">설문조사 진행하기<br>
				<input type="radio" name="menu" value="2">설문조사 결과지 확인하기<br>
				<input type="radio" name="menu" value="0">설문 종료<br>
				<br><input type="submit" value="전송" onclick='getmenu()'>
			</form>
		</article>

	</section>

</body>
</html>