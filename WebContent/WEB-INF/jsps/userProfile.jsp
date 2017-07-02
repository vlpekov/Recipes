<%@ page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/user_profile.css">
<title>User profile</title>
</head>
<script>
	function resizeIframe(obj) {
		obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
		obj.style.width = obj.contentWindow.document.body.scrollWidth + 'px';
	}
</script>
<jsp:useBean id="tags" class="com.javabeans.UserProfileTags" />
<jsp:useBean id="cookieManager" class="com.javabeans.CookiesManager" />
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
			<h1><%=request.getAttribute(tags.getFirstName())%>
				<%=request.getAttribute(tags.getLastName())%></h1>
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
		<div class="recipes">
			<img border="0" alt="Рецептурник" src="img/hr2top.png"
				class="hr_img_bottom">
			<h2>Публикувани рецепти</h2>
			<img border="0" alt="Рецептурник" src="img/hr2.png"> </a>
			<div style="text-align: center">
				<iframe src="user_recipes?username=<%=request.getParameter("username")%>" style="border: none;" frameborder="0"
					scrolling="no" onload="resizeIframe(this)"> </iframe>
			</div>
		</div>
	</div>
</body>
</html>