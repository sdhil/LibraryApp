<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>Library Homepage</title>
</head>
<body>
	<h1>Welcome to the GCIT Library Management System.</h1>
	<c:if test="${not empty login_message }">
	<font color="red">
		<c:out value="${login_message }"></c:out>
	</font>
</c:if>
	<form method="post" action="login.do" >
		<fieldset>
			<legend>
				<h3>Login Here!</h3>
			</legend>
			Username:
			</legend>
			<br /> <input type="text" name="username" /> <br /> Password: <br />
			<input type="password" name="password" /> <br /> <input
				type="submit" value="Login" /> <br />
		</fieldset>
	</form>
</body>
</html>