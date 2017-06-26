<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.database.utilities.*"%>
<%@ page import="com.javabeans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/body.css">
<title>Рецептурник</title>
</head>

<body class="tablecloth">
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
	%>

</body>
</html>