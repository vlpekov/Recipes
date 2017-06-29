<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/user_profile.css">
<title>User profile</title>
</head>
<jsp:useBean id="tags" class="com.javabeans.UserProfileNames" />
<%!String username;%>
<%
	username = request.getParameter("username");
%>
<body>
	<div class="container">
		<div class="site_label">
			<a href="/Recipes/" target="_top"> <img border="0"
				alt="Рецептурник" src="img/label.png" height="150">
			</a>
		</div>
		<div class="username">
			<h2><%=request.getAttribute(tags.getFirstName())%>
				<%=request.getAttribute(tags.getLastName())%></h2>
			<img class="hr_img" border="0" src="img/hr.png">
		</div>
		<table>
			<tr>
				<td class="left_column"><img
					src="userImg?username=<%=username%>" class="square_pic img_frame"></td>
				<td><div>
						<h3>Потребителско име:</h3>
						<h4>
							<%=request.getAttribute(tags.getUsername())%></h4>
					</div>
					<div>
						<h3>E-mail:</h3>
						<h4><%=request.getAttribute(tags.getEmail())%></h4>
					</div>
					<h3>Дата на регистрация:</h3>
					<h4>
						<%=request.getAttribute(tags.getRegistrationDate())%></h4></td>
			</tr>
		</table>
	</div>
</body>
</html>