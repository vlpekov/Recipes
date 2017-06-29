<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/profile_picture.css">
<title>Insert title here</title>
</head>
<body>
	<%!String username;%>
	<%
		username = request.getParameter("username");
	%>
	<img src="userImg?username=<%=username%>" class="circle_pic"
		width="120" height="120" style="border-radius: 50%">
	<h2>
		Добре дошъл, <a href="getUser?username=<%=username%>"
			target="_parent"> <%=username%></a>
	</h2>
</body>
</html>