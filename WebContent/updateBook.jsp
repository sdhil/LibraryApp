<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<h1>GCIT Library Books List</h1>
<a href="home.jsp"><button>LogOut</button></a>
<a href="admin.jsp"><button>Back</button></a>
<table class="table table-striped">
	<tr><th>BookId</th><th>Title</th><th>Authors</th><th>Genres</th><th>Publisher</th></tr>
	<c:forEach var="book" items="${books }">
	<tr>
		<td><c:out value="${book.id }"></c:out></td>
		<td><c:out value="${book.title }"></c:out></td>
		<td>
			<c:forEach var="author" items="${book.authors }">
				<c:out value="${author.name },  "> </c:out>
			</c:forEach>
		</td>
		<td>
			<c:forEach var="genre" items="${book.genres }">
				<c:out value="${genre.name },  "> </c:out>
			</c:forEach>
		</td>
		<td><c:out value="${book.publisher.name }"></c:out></td>
	</tr>
	</c:forEach>
</table>
<body>

</body>
</html>