<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.database.utilities.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	    <H1>JSP sending two cookies to client </H1>
    <%
      Cookie userIdCookie= new Cookie("userID", "guest");
      userIdCookie.setMaxAge(24*60*60);
      Cookie createdBy= new Cookie("createdBy","sendCookieJSP" );
      createdBy.setMaxAge(24*60*60);
      response.addCookie(userIdCookie);
      response.addCookie(createdBy);
    %>
    <H1>JSP Reading two cookies to client </H1>
    <table border=”1”>
     <tr>
      <td>Cookie Name </td>
      <td>Cookie Value </td>
      <td>Cookie Max Age  </td>
     </tr>
     <%
       Cookie[] cookies= request.getCookies();
       // check null because there are chances that there are no cookies
       if(cookies !=null)
       {
         for(int i=0 ;i<cookies.length;i++ )
         {
           Cookie cookie = cookies[i];
           out.println(" <tr> ");
           out.println("<td>" + cookie.getName() + "</td>" );
           out.println("<td>" + cookie.getValue() + "</td>" );
           out.println("<td>" + cookie.getMaxAge() + "</td>" );
           out.println(" </tr> ");
         }
       }
     %>
    </table>
  </body>
	<%
// 		Cookie[] cookies = request.getCookies();
		String username = "";
		String password = "";
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("username-cookie")) {
					username = cookie.getValue();
				} else if (cookie.getName().equals("password-cookie")) {
					password = cookie.getValue();
				}
			}
		}
	%>
	<form name="logonform" action="displayHomePage.jsp" method="POST">
		Username: <input type="text" name="username" value="<%=username%>" />
		<br /> Password:<input type="password" name="password"
			value="<%=password%>" /> <br /> Remember Me<input type="checkbox"
			name="rememberMe" value="true" /> <input type="submit" value="Submit" />
	</form>
</body>
</html>