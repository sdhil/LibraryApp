<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>Administrator</title>
</head>
<body>
<c:if test="${not empty message }">
	<font color="red">
		<c:out value="${message }"></c:out>
	</font>
</c:if>
<h1><font color="red">Hello <c:out value="${user_data.username}"></c:out></font></h1>
<a href="home.jsp"><button>LogOut</button></a>
<h2>Please choose one of the following</h2>
<h3>Book </h3>
<form method="post" action="addBook.do">
Title: <input type="text" name="book_name" /> 
Author: <select multiple="multiple" name="selected_authors"  >
<c:forEach var = "author" items = "${authors }">
<option value="${author.id }"> <c:out value="${author.name }"></c:out></option>
</c:forEach>
</select>
Genre: <select multiple="multiple" name="selected_genres" >
<c:forEach var = "genre" items = "${genres }">
<option value="${genre.id }"> <c:out value="${genre.name }"></c:out></option>
</c:forEach>
</select>
Publisher: <select name="selected_publisher" style="height:25px;">
<c:forEach var = "pub" items = "${publishers }">
<option value="${pub.id }"> <c:out value="${pub.name }"></c:out></option>
</c:forEach>
</select>
<input type="submit" value="Add"> <br/><br/>
</form>
<a href="updateBook.do" ><button>Update Existing Records</button></a> <br><br>
<a href="#"><button>Delete Existing Records</button></a> <br><br>
<hr/>

<h3>Author </h3>
<form method="post" action="addAuthor.do">
Name: <input type="text" name="author_name" />  
<input type="submit" value="Add"> <br/><br/>
</form>
<a href="updateAuthor.do"><button>Update Existing Records</button></a> <br><br>
<a href="#.jsp"><button>Delete Existing Records</button></a> <br><br>
<hr/>

<h3>Genre </h3>
<form method="post" action="addGenre.do">
Name: <input type="text" name="genre_name" />  
<input type="submit" value="Add"> <br/><br/>
</form>
<a href="updateGenre.do"><button>Update Existing Records</button></a> <br><br>
<a href="deleteGenre.jsp"><button>Delete Existing Records</button></a> <br><br>
<hr/>

<h3>Publishers</h3>
<form method="post" action="addPublisher.do">
Name: <input type="text" name="publisher_name" />  
Address: <input type="text" name="publisher_address" />
Phone: <input type="text" name="publisher_phone" />
<input type="submit" value="Add"> <br/><br/>
</form>
<a href="updatePublisher.do"><button>Update Existing Records</button></a> <br><br>
<a href="deletePublisher.jsp"><button>Delete Existing Records</button></a> <br><br>
<hr/>

<h3>Library Branches</h3>
<form method="post" action="addBranch.do">
Name: <input type="text" name="branch_name" />  
Address: <input type="text" name="branch_address" />
<input type="submit" value="Add"> <br/><br/>
</form>
<a href="updateBranch.jsp"><button>Update Existing Records</button></a> <br><br>
<a href="deleteBranch.jsp"><button>Delete Existing Records</button></a> <br><br>
<hr/>

<h3>Borrowers</h3>
<form method="post" action="addBorrower.do">
Name: <input type="text" name="borrower_name" />  
Address: <input type="text" name="borrower_address" />
Phone: <input type="text" name="borrower_phone" />
<input type="submit" value="Add"> <br/><br/>
</form>
<a href="updateBorrower.jsp"><button>Update Existing Records</button></a> <br><br>
<a href="deleteBorrower.jsp"><button>Delete Existing Records</button></a> <br><br>
<hr/>
</body>
</html>