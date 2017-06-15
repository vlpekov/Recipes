<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.vso.interfaces.RegistrationForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/registration.css">
<title>Регистрация на потребител</title>
</head>
<body>
	<jsp:useBean id="filds" class="com.javabeans.FormRegistration" />
	<form class="form-container" action="validation" method="post"
		enctype="multipart/form-data">

		<fieldset class="form-box">
			<legend>Регистрация</legend>



			<table>
				<tr>
					<td><div class="form-title">Потребителско име:</div></td>
					<td><input class="form-field" type="text"
						name=<%=filds.getUsernameInputName()%> required="required" /></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<%
							String usernameCheck = (String) request.getAttribute("usernameCheck");
							if (usernameCheck != null) {
								out.println(usernameCheck);
							}
						%>
					</td>

				</tr>
				<tr>
					<td><div class="form-title">Име:</div></td>
					<td><input class="form-field" type="text"
						name=<%=filds.getFirstNameInputName()%> required="required" /></td>
				</tr>
				<tr>
					<td><div class="form-title">Фамилия:</div></td>
					<td><input class="form-field" type="text"
						name=<%=filds.getSecondNameInputName()%> required="required" /></td>
				</tr>
				<tr>
					<td><div class="form-title">E-mail:</div></td>
					<td><input class="form-field" type="email"
						name=<%=filds.getEmailInputName()%> required="required" /></td>
				</tr>
				<tr>
					<td><div class="form-title">Парола:</div></td>
					<td><input type="password" class="form-field"
						name=<%=filds.getPasswordInputName()%> required="required"></td>
				</tr>


				<tr>
					<td><div class="form-title">Потвърдете паролата:</div></td>
					<td><input type="password" class="form-field"
						name=<%=filds.getPasswordConfirmInputName()%> required="required"></td>

				</tr>

				<tr>
					<td></td>
					<td>
						<%
							String status = (String) request.getAttribute("status");
							if (status != null) {
								out.println(status);
							}
						%>
					</td>

				</tr>
				<tr>
					<td><label for="picture" class="form-title">Профилна
							снимка:</label></td>
					<td><input style="padding-top: 3px;" type="file" name="image"
						required="required" /></td>

				</tr>
			</table>
			<input class="brown_button" type="submit" name="submit" /> <a
				class="white_button" href="login.jsp">Отказ</a>


		</fieldset>
	</form>

</body>
</html>