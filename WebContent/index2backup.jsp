<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.database.utilities.*"%>
<%@ page import="com.javabeans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Рецептурник</title>
<jsp:useBean id="filds" class="com.javabeans.FormRegistration" />
<jsp:useBean id="cookieManager" class="com.javabeans.CookiesManager" />
<%
		SetupDB single = SetupDB.getInstance();
		SetupDB.getStatement();
	%>
<%!boolean isLoggedIn = false;%>
<%
		Cookie[] cookies = request.getCookies();
		isLoggedIn = cookieManager.isUserCorrect(cookies);
		System.out.println(session.getAttribute("name") + " ----------------------index---------------seasion");
	%>

</head>
<%
	if (session.getAttribute("name")!= null) {
%>
<frameset rows="145px,*">
	<frame src="header" name="header" style="border:none" framespacing="0" noresize="noresize"
		scrolling="no">
	<frameset cols="20%,*">
		<frame src="frame2.jsp" name="" style="border:none" framespacing="0" noresize="noresize"
			scrolling="no">
		<frame src="body" name="body" style="border:none" framespacing="0" noresize="noresize"
			scrolling="no">
	</frameset>
</frameset>
<%
	} else {
%>
<frameset rows="150px,*">
	<frame src="header" name="header" style="border:none" frameborder="0" framespacing="0" noresize="noresize"
		scrolling="no">
	<frame src="body" name="body" frameborder="0" style="border:none" framespacing="0" noresize="noresize"
		scrolling="no">
</frameset>
<%
	}
%>
</body>
</html>