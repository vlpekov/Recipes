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
</head>
<frameset rows="300px,*">
<frame src="header" name="frame1" frameborder="0" noresize="noresize" scrolling="no">
<frameset cols="20%,*">
<frame src="frame2.jsp" name="frame2" frameborder="0" noresize="noresize" scrolling="no">
<frame src="frame3.jsp" name="frame3" frameborder="0" noresize="noresize" scrolling="no">
</frameset>
</frameset>
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

	<div class="header">
		<div class="left_header">
			<%
				if (isLoggedIn) {
			%>
			<h1>
				Добре дошъл,
				<%=cookieManager.getCurrentUsername()%><%=session.getAttribute("name")%></h1>
			<%
				}
			%>
		</div>
		<div class="midle_header">
			<a href="index.jsp"> <img border="0" alt="Рецептурник"
				src="img/label.png" height="110">
			</a>
		</div>
		<div class="right_header">
			<form action="login" method="post">
				<div class="login_field">
					<input type="text" required="required"
						name=<%=filds.getUsernameInputName()%>>
				</div>
				<table>
					<tr>
						<td><div class="login_field_bottom">
								<input type="password" placeholder="******"
									name=<%=filds.getPasswordInputName()%>>
							</div></td>
						<td><input class="red_button" type="submit" value="Вход" /></td>
					</tr>
					<tr>
						<td><a href="register"> <img border="0"
								alt="Регистрирай се" src="img/register.png" height="18"></a>
						<td>
					</tr>
				</table>
			</form>
		</div>
	</div>


</body>
</html>