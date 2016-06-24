package com.gcit.lms.MVC;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.lms.service.AdminService;
import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.Borrower;
import com.gcit.lms.domain.Branch;
import com.gcit.lms.domain.Genre;
import com.gcit.lms.domain.Publisher;
import com.gcit.lms.domain.User;

public class Model {

	public boolean addPublisher(HttpServletRequest req, HttpServletResponse resp) {
		Publisher publisher = new Publisher();
		if (req.getParameter("publisher_name").equals("")) {
			req.setAttribute("message", "Failed! Error: Publisher name has to be non-empty");
			return false;
		}
		publisher.setName(req.getParameter("publisher_name"));
		publisher.setAddress(req.getParameter("publisher_address"));
		publisher.setPhone(req.getParameter("publisher_phone"));
		boolean insertPublisher = new AdminService().insertPublisher(publisher);
		if (insertPublisher) {
			req.setAttribute("message", "Successfully added the publisher");
			return true;
		} else {
			req.setAttribute("message", "Something failed. Could not add publisher");
			return false;
		}
	}

	public boolean addBranch(HttpServletRequest req, HttpServletResponse resp) {
		Branch branch = new Branch();
		branch.setBranchName(req.getParameter("branch_name"));
		branch.setBranchAddress(req.getParameter("branch_address"));
		boolean insertBranch = new AdminService().insertBranch(branch);
		if (insertBranch) {
			req.setAttribute("message", "Successfully added the branch");
			return true;
		} else {
			req.setAttribute("message", "Something failed. Could not add branch");
			return false;
		}
	}

	public boolean addBorrower(HttpServletRequest req, HttpServletResponse resp) {
		Borrower borrower = new Borrower();
		borrower.setName(req.getParameter("borrower_name"));
		borrower.setAddress(req.getParameter("borrower_address"));
		borrower.setPhone(req.getParameter("borrower_phone"));
		boolean insertBorrower = new AdminService().insertBorrower(borrower);
		if (insertBorrower) {
			req.setAttribute("message", "Successfully added the borrower");
			return true;
		} else {
			req.setAttribute("message", "Something failed. Could not add branch");
			return false;
		}
	}

	public boolean addBook(HttpServletRequest req, HttpServletResponse resp) {
		Book book = new Book();
		book.setTitle(req.getParameter("book_name"));
		String publisherId = req.getParameter("selected_publisher");
		book.setPublisher(new Publisher(Integer.parseInt(publisherId)));
		String[] authors = req.getParameterValues("selected_authors");
		List<Author> authorList = new ArrayList<Author>();
		for (String authorId : authors) {
			authorList.add(new Author(Integer.parseInt(authorId)));
		}
		book.setAuthors(authorList);
		String[] genres = req.getParameterValues("selected_genres");
		List<Genre> genreList = new ArrayList<Genre>();
		for (String genreId : genres) {
			genreList.add(new Genre(Integer.parseInt(genreId)));
		}
		book.setGenres(genreList);
		boolean insertBook = new AdminService().insertBook(book);
		if (insertBook) {
			req.setAttribute("message", "Successfully added the book");
			return true;
		} else {
			req.setAttribute("message", "Something failed. Could not add book");
			return false;
		}
	}

	public boolean addAuthor(HttpServletRequest req, HttpServletResponse resp) {
		Author author = new Author();
		author.setName(req.getParameter("author_name"));
		boolean insertAuthor = new AdminService().insertAuthor(author);
		if (insertAuthor) {
			req.setAttribute("message", "Successfully added the author");
			return true;
		} else {
			req.setAttribute("message", "Something failed. Could not add Author");
			return false;
		}

	}

	public boolean getAllAuthors(HttpServletRequest req, HttpServletResponse resp) {
		List<Author> authors = new AdminService().getAllAuthors();
		if (authors != null) {
			req.getSession().setAttribute("authors", authors);
			return true;
		} else {
			req.setAttribute("message", "Fetching all authors failed.");
			return false;
		}
	}

	public boolean addGenre(HttpServletRequest req, HttpServletResponse resp) {
		Genre genre = new Genre();
		genre.setName(req.getParameter("genre_name"));
		boolean insertGenre = new AdminService().insertGenre(genre);
		if (insertGenre) {
			req.setAttribute("message", "Successfully added the genre");
			return true;
		} else {
			req.setAttribute("message", "Something failed. Could not add Genre");
			return false;
		}
	}

	public boolean getAllGenres(HttpServletRequest req, HttpServletResponse resp) {
		List<Genre> genres = new AdminService().getAllGenres();
		if (genres != null) {
			req.getSession().setAttribute("genres", genres);
			return true;
		} else {
			req.setAttribute("genres", "Fetching all genres failed.");
			return false;
		}
	}

	public boolean getAllPublishers(HttpServletRequest req, HttpServletResponse resp) {
		List<Publisher> publishers = new AdminService().getAllPublishers();
		if (publishers != null) {
			req.getSession().setAttribute("publishers", publishers);
			return true;
		} else {
			req.setAttribute("publishers", "Fetching all genres failed.");
			return false;
		}
	}

	public boolean getAllBooks(HttpServletRequest req, HttpServletResponse resp) {
		List<Book> books = new AdminService().getAllBooks();
		if (books != null) {
			req.getSession().setAttribute("books", books);
			return true;
		} else {
			req.getSession().setAttribute("message", "Something failed. Could not fetch all Books");
			return false;
		}

	}

	public int login(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new AdminService().login(username, password);
		if (user != null && user.getPassword().equals(password)) {
			req.getSession().setAttribute("user_data", user);
			if(user.getRoleid() == 1)
				return 1;
			else if (user.getRoleid() == 2) 
				return 2;
			else if (user.getRoleid() == 3) {
				return 3;
			}
		} else {
			req.setAttribute("login_message", "Authentication failed! Try again");
		}
		return 0;
	}
}
