<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style.css" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<h1>GCIT Library Genres List</h1>
<a href="home.jsp"><button>LogOut</button></a>
<a href="admin.jsp"><button>Back</button></a>
<table class="table table-striped">
	<tr><th>GenreId</th><th>Name</th><th>Books</th></tr>
	<c:forEach var="genre" items="${genres }">
	<tr>
		<td><c:out value="${genre.id }"></c:out></td>
		<td><c:out value="${genre.name }"></c:out></td>
		<td>
			<c:forEach var="book" items="${genre.books }">
				<c:out value="${book.title },  "> </c:out>
			</c:forEach>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>