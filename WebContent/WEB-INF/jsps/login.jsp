<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.database.utilities.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>Insert title here</title>
</head>
<body class="tablecloth">
	<div class="registration_success">
		<center>
			<%
				String usernameCheck = (String) request.getAttribute("registrationSuccess");
				if (usernameCheck != null) {
					out.println(usernameCheck);
				}
			%>
			<h2>Поздравления<br>Регистрирахте се успешно.<br>Може да се впишете:</h2>
		</center>
		
		
	</div>
	<div class="login_field">
		<form class="form-container" action="login" method="post">
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
	</div>

</body>
</html>