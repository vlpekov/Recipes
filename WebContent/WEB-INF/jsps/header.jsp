<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.database.utilities.*"%>
<%@ page import="com.javabeans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/header.css">
<title>Header</title>
</head>
<body>
	<jsp:useBean id="filds" class="com.javabeans.FormRegistration" />
	<jsp:useBean id="cookieManager" class="com.javabeans.CookiesManager" />
	<%
		SetupDB single = SetupDB.getInstance();
		SetupDB.getStatement();
	%>
	<%!boolean isLoggedIn = false;
	String guestElements = "";
	String userElements = "";%>
	<%
		Cookie[] cookies = request.getCookies();
		isLoggedIn = cookieManager.isUserCorrect(cookies);
		if (isLoggedIn) {
			guestElements = "hidden";
			userElements = "";
		} else {
			guestElements = "";
			userElements = "hidden";
		}
	%>
	<div class="header">
		<div class="left_header">
			<h3>
				Добре дошъл,
				<%=cookieManager.getCurrentUsername()%>
				(Сесия:
				<%=session.getAttribute("name")%>)
			</h3>
		</div>
		<div class="midle_header">
			<a href="index.jsp"> <img border="0" alt="Рецептурник"
				src="img/label.png" height="110">
			</a>
		</div>
		<div class="right_header">
			<form <%=guestElements%> action="login" method="post">
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
						<td><a href="register" target="_top"> <img border="0"
								alt="Регистрирай се" src="img/register.png" height="18"></a>
						<td>
					</tr>
				</table>
			</form>
			<div <%=userElements%> >
				<table>
					<tr>
						<td>
							<h2>
								Добре дошъл,
								<%=cookieManager.getCurrentUsername()%>
								(Сесия:
								<%=session.getAttribute("name")%>)
							</h2>
						</td>
					<tr>
						<td class="right"><a class="button" href="logout" target="_top">Изход</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>