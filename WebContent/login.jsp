<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div class="loginForm">
<h1>Login</h1>
	<form action="login.do" method="post">
		<table>
			<tr>
				<td>Enter Username :</td>
				<td><input type="text" name="email" id="emailId"></td>
			</tr>
			<tr>
				<td>Enter Password :</td>
				<td><input type="password" name="pass" id="passwordId"></td>
			</tr>

		</table>
		<input class="button" type="submit" value="Login"> 	
		<br><br>
		<a href="RegisterPage.jsp">New User</a>	
	</form>
	
</div>
</body>
</html>