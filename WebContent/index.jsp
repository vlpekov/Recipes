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
%>
<%
	String guestElements = "";
	String userElements = "";
%>
<%
	isLoggedIn = cookieManager.isUserCorrect(cookies);
	if (isLoggedIn) {
		guestElements = "hidden";
		userElements = "";
	} else {
		guestElements = "";
		userElements = "hidden";
	}
%>
</head>
<body class="tablecloth">

	<div class="header_body">
		<div class="left_header">
			<iframe
				src="profile_picture?username=<%=cookieManager.getCurrentUsername()%>"
				style="border: none;"> </iframe>
<!-- 			<h3> -->
<!-- 				Добре дошъл, <a -->
<%-- 					href="getUser?username=<%=cookieManager.getCurrentUsername()%>"><%=cookieManager.getCurrentUsername()%></a> --%>
<!-- 				(Сесия: -->
<%-- 				<%=session.getAttribute("name")%>) --%>
<!-- 			</h3> -->
		</div>
		<div class="midle_header">
			<a href="/Recipes/" target="_top"> <img border="0"
				alt="Рецептурник" src="img/label.png" height="110">
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

		<nav> <a href="new_recipe">Публикувай рецепта</a> <a href="">Моите
			рецепти</a> <a href="#section3">Сготви рецепта</a> </nav>
		<article>
		<h1>A Better Approch Than Tables or Frames</h1>
		<p>
			This working file is a <strong>fixed-width layout</strong> made
			possible through the use of HTML5 tags and CSS3.
		</p>
		<p>You can use this instead of tables or frames. Feel free to
			adapt this as much as you want to make your own website layout.</p>
		<hr>
		<h2>Dividing The Page Into Sections</h2>
		<section>
		<div class="thirds">
			<p>You can split up your content into columns, but be careful of
				not exceeding 100%.</p>
		</div>
		<div class="thirds">
			<p>If you do, you will find one of your intended 'columns' is
				pushed underneath the others.</p>
		</div>
		<div class="thirds last">
			<p>
				This may take some tweaking of the <strong>width</strong> and <strong>margin-right</strong>
				properties.
			</p>
		</div>
		</section>
		<hr>
		<h2>Go Halves</h2>
		<section>
		<div class="halves">
			<p>You can equally divide the page into halves. Just bear in mind
				that your 100% is a total of your column width percentages and your
				margin percentages.</p>
			<p>
				We have used a <strong>.last</strong> class to ensure there is no <strong>margin-right</strong>
				on the final column so it sits flush to the right of our site.
			</p>
		</div>
		<div class="halves last">
			When in doubt, do the maths.<br>
			<ul>
				<li>2 Columns at 49% = 98%</li>
				<li>Add one margin right at 1%. Total is now 99%;</li>
				<li>This means for 50% width in this case you should have done:
					(100% - 1%) divided by 2 = 49.5%</li>
			</ul>
		</div>
		</section> </article>
		<footer> Example Code Courtesy of <a
			href="https://resource-centre.net" title="The Free Tutorial Centre">The
			Free Tutorial Centre</a> </footer>
	</div>
</html>