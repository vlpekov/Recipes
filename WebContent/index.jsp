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

	<div class="header">
		<div class="left_header"></div>
		<div class="midle_header">
			<a href="index.jsp"> <img border="0" alt="Рецептурник"
				src="img/label.png" height="110">
			</a>
		</div>
		<div class="right_header">
			<div class="login_field">
				<input type="text">
			</div>
			<table>
				<tr>
					<td><div class="login_field_bottom"> <input
						type="password" placeholder="******">
					</div></td>
					<td><input class="red_button" type="submit" value="Вход" /></td>
				</tr>
			</table>
		</div>
	</div>



</body>
</html>