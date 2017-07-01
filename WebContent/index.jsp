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
<jsp:useBean id="filds" class="com.javabeans.IndexTagsNames" />
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
<%
	String guestElements = "";
	String userElements = "";
	int iframeColumns;
%>
<%
	isLoggedIn = cookieManager.isUserCorrect(cookies);
	if (isLoggedIn) {
		guestElements = "hidden";
		userElements = "";
		iframeColumns = 3;
	} else {
		guestElements = "";
		userElements = "hidden";
		iframeColumns = 4;
	}
%>
</head>
<script>
	function resizeIframe(obj) {
		obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
		obj.style.width = obj.contentWindow.document.body.scrollWidth + 'px';
	}
</script>
<body class="tablecloth">

	<div class="header_body">
		<div class="left_header">
			<iframe
				src="profile_picture?username=<%=cookieManager.getCurrentUsername()%>"
				style="border: none;" <%=userElements%>> </iframe>
		</div>
		<div class="midle_header" class="site_label">
			<a href="/Recipes/" target="_top"> <img  border="0"
				alt="Рецептурник" src="img/label.png" height="150">
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
						<td><input target="_top" class="red_button" type="submit"
							value="Вход" /></td>
					</tr>
					<tr>
						<td><a href="register" target="_top"> <img border="0"
								alt="Регистрирай се" src="img/register.png" height="18"></a>
						<td>
					</tr>
				</table>
			</form>
			<div <%=userElements%>>
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
						<td class="right"><a class="button" href="logout"
							target="_top">Изход</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="container">

		<nav <%=userElements%>> <a href="new_recipe">Публикувай
			рецепта</a> <a href="getUser?username=<%=cookieManager.getCurrentUsername()%>">Моите рецепти</a> <a href="#section3">Сготви
			рецепта</a> </nav>
		<div style="text-align: center">
			<iframe src="list?iframeColumns=<%=iframeColumns%>"
				style="border: none;" frameborder="0" scrolling="no"
				onload="resizeIframe(this)"> </iframe>
		</div>
	</div>
</html>