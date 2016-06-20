package com.gcit.lms.MVC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqURI = req.getRequestURI();
		switch (reqURI) {
		case "/LibraryApp/login.do": {
			int authentication = new Model().login(req, resp);
			if (authentication == 1) {
				new Model().getAllAuthors(req, resp);
				new Model().getAllGenres(req, resp);
				new Model().getAllPublishers(req, resp);
				req.getRequestDispatcher("admin.jsp").forward(req, resp);
			} else if (authentication == 2) {
				req.getRequestDispatcher("librarian.jsp").forward(req, resp);;
			} else if (authentication == 3) {
				req.getRequestDispatcher("borrower.jsp").forward(req, resp);;
			} else {
				req.getRequestDispatcher("home.jsp").forward(req, resp);
			}
			
			break;
		}
		case "/LibraryApp/admin.do": {
			new Model().getAllAuthors(req, resp);
			new Model().getAllGenres(req, resp);
			new Model().getAllPublishers(req, resp);
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
			break;
		}
		case "/LibraryApp/addBook.do": {
			new Model().addBook(req, resp);	
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
			break;
		}
		case "/LibraryApp/addAuthor.do": {
			new Model().addAuthor(req, resp);
			new Model().getAllAuthors(req, resp);
			new Model().getAllGenres(req, resp);
			new Model().getAllPublishers(req, resp);
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
			break;
		}
		case "/LibraryApp/addGenre.do": {
			new Model().addGenre(req, resp);
			new Model().getAllAuthors(req, resp);
			new Model().getAllGenres(req, resp);
			new Model().getAllPublishers(req, resp);
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
			break;
		}
		case "/LibraryApp/addPublisher.do": {
			new Model().addPublisher(req, resp);
			new Model().getAllAuthors(req, resp);
			new Model().getAllGenres(req, resp);
			new Model().getAllPublishers(req, resp);
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
			break;
		}
		case "/LibraryApp/addBranch.do": {
			new Model().addBranch(req, resp);
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
			break;
		}
		case "/LibraryApp/addBorrower.do": {
			new Model().addBorrower(req, resp);
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
			break;
		}
		case "/LibraryApp/updateBook.do": {
			boolean result = new Model().getAllBooks(req, resp);
			if(result)
				req.getRequestDispatcher("updateBook.jsp").forward(req, resp);
			else
				req.getRequestDispatcher("admin.jsp").forward(req, resp);
			break;
		}
		case "/LibraryApp/updateAuthor.do": {
			boolean result = new Model().getAllAuthors(req, resp);
			if(result)
				req.getRequestDispatcher("updateAuthor.jsp").forward(req, resp);
			else
				req.getRequestDispatcher("admin.jsp").forward(req, resp);
			break;
		}
		case "/LibraryApp/updatePublisher.do": {
			boolean result = new Model().getAllPublishers(req, resp);
			if(result)
				req.getRequestDispatcher("updatePublisher.jsp").forward(req, resp);
			else
				req.getRequestDispatcher("admin.jsp").forward(req, resp);
			break;
		}
		case "/LibraryApp/updateGenre.do": {
			boolean result = new Model().getAllGenres(req, resp);
			if(result)
				req.getRequestDispatcher("updateGenre.jsp").forward(req, resp);
			else
				req.getRequestDispatcher("admin.jsp").forward(req, resp);
			break;
		}
		default:{
			throw new IllegalArgumentException("Invalid URL");
		}
		}
	}

}
