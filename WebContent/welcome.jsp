<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<form action="logout.do">
<%

	response.setHeader("Cache-Control", "no-cache,no-store,no-revalidate");
	HttpSession httpSession=request.getSession();

	if(httpSession.getAttribute("Username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	
	
%>
<h2>Welcome ${Username}</h2>
<br>
<a href="Visit.jsp">visit here</a>
<input type="submit" value="logout">
</form>
</body>
</html>