package MVC;

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
		case "/LibraryApp/addBookAuthor.do": {
			new Model().addBookAuthor(req, resp);
		}
		case "/LibraryApp/addPublisher.do": {
			new Model().addPublisher(req, resp);
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
		}
		case "/LibraryApp/addBranch.do": {
			new Model().addBranch(req, resp);
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
		}
		case "/LibraryApp/addBorrower.do": {
			new Model().addBorrower(req, resp);
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
		}
		default:{
			throw new IllegalArgumentException("Invalid URL");
		}
		}
	}

}
