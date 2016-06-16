<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty message }">
	<font color="red">
		<c:out value="${message }"></c:out>
	</font>
</c:if>
<h1>Hello Admin</h1>
<h2>Please choose one of the following</h2>
<h3>Book and Author</h3>
<form method="post" action="addBookAuthor.do">
Name: <input type="text" name="book_name" />  
Author: <input type="text" name="author_name" />
Genre: <input type="text" name="genre" />
Publisher: <input type="text" name="publisher_name" />
<input type="submit" value="Add"> <br/><br/>
</form>
<a href="updateBookAuthor.jsp"><button>Update Existing Records</button></a> <br><br>
<a href="deleteBookAuthor.jsp"><button>Delete Existing Records</button></a> <br><br>
<hr/>

<h3>Publishers</h3>
<form method="post" action="addPublisher.do">
Name: <input type="text" name="publisher_name" />  
Address: <input type="text" name="publisher_address" />
Phone: <input type="text" name="publisher_phone" />
<input type="submit" value="Add"> <br/><br/>
</form>
<a href="updatePublisher.jsp"><button>Update Existing Records</button></a> <br><br>
<a href="deletePublisher.jsp"><button>Delete Existing Records</button></a> <br><br>
<hr/>

<h3>Library Branches</h3>
<form method="post" action="addBranch.do">
Name: <input type="text" name="branch_name" />  
Address: <input type="text" name="branch_address" />
<input type="submit" value="Add"> <br/><br/>
</form>
<a href="updatePublisher.jsp"><button>Update Existing Records</button></a> <br><br>
<a href="deletePublisher.jsp"><button>Delete Existing Records</button></a> <br><br>
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