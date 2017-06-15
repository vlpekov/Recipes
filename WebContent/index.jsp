<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.database.utilities.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Рецептурник</title>
</head>
<body class="tablecloth">
	<%
		SetupDB single = SetupDB.getInstance();
		SetupDB.getStatement();
	%>

	<div class="top_bar">
		<form action="Login" method="post">
			<fieldset style="width: 300px;">
				<legend> Потребителски вход: </legend>
				<table>
					<tr>
						<td>Потребител:</td>
						<td><input type="text" name="username" required="required" /></td>
					</tr>
					<tr>
						<td>Парола:</td>
						<td><input type="password" name="password"
							required="required" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Вход" /></td>

					</tr>
				</table>
			</fieldset>
		</form>
	</div>

	<form class="form-container" action="Login" method="post">
		<div class="form-title">
			<h2>Вход</h2>
		</div>
		<div class="form-title">Потребителско име:</div>
		<input class="form-field" type="text" name="username"
			required="required" /><br />
		<div class="form-title">Парола:</div>
		<input class="form-field" type="password" name="password"
			required="required" /><br />
		<div class="submit-container">
			<input class="brown_button" type="submit" value="Вход" />
		</div>
	</form>

</body>
</html>