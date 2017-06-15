<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Insert title here</title>
</head>
<body>
	<h3>Успешен вход</h3>
	<h4>
		Здравей,
		<%=session.getAttribute("name")%></h4>
	<table border=”1”>
		<%
			Cookie[] cookies = request.getCookies();
			// check null because there are chances that there are no cookies
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					out.println(" <tr> ");
					out.println("<td>" + cookie.getName() + "</td>");
					out.println("<td>" + cookie.getValue() + "</td>");
					out.println("<td>" + cookie.getMaxAge() + "</td>");
					out.println(" </tr> ");
				}
			}
		%>
	</table>

	<a href="Logout" class="brown_button">Изход</a>
</body>
</html>