package MVC;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.BusinessDelegate;
import domain.Author;
import domain.Book;
import domain.Borrower;
import domain.Branch;
import domain.Genre;
import domain.Publisher;

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
		
		boolean insertPublisher = new BusinessDelegate().insertPublisher(publisher);
		if(insertPublisher) {
			req.setAttribute("message", "Successfully added the publisher");
			return true;
		} else {
			req.setAttribute("message", "Something failed. Could not add publisher");
			return false;
		}
	}
	
	public static Publisher fetchPublisher(String name) {
		Publisher publisher = new BusinessDelegate().fetchPublisher(name);
		return publisher;
	}

	public boolean addBranch(HttpServletRequest req, HttpServletResponse resp) {
		Branch branch = new Branch();
		branch.setBranchName(req.getParameter("branch_name"));
		branch.setBranchAddress(req.getParameter("branch_address"));
		
		boolean insertBranch = new BusinessDelegate().insertBranch(branch);
		if(insertBranch) {
			req.setAttribute("message", "Successfully added the branch");
			return true;
		} else {
			req.setAttribute("message",  "Something failed. Could not add branch");
			return false;
		}
	}

	public boolean addBorrower(HttpServletRequest req, HttpServletResponse resp) {
		Borrower borrower = new Borrower();
		borrower.setName(req.getParameter("borrower_name"));
		borrower.setAddress(req.getParameter("borrower_address"));
		borrower.setPhone(req.getParameter("borrower_phone"));
		
		boolean insertBorrower = new BusinessDelegate().insertBorrower(borrower);
		if(insertBorrower) {
			req.setAttribute("message", "Successfully added the borrower");
			return true;
		} else {
			req.setAttribute("message", "Something failed. Could not add branch");
			return false;
		}
	}

	public boolean addBookAuthor(HttpServletRequest req, HttpServletResponse resp) {
		Book book = new Book();
		String auths = req.getParameter("author_name");
		String gens = req.getParameter("genre_name");
		List<Author> authors = new ArrayList<Author>();
		List<Genre> genres = new ArrayList<Genre>();
		StringTokenizer st1 = new StringTokenizer(auths, ",");
		StringTokenizer st2 = new StringTokenizer(gens, ",");
		while(st1.hasMoreTokens()) {
			Author author = new Author(st1.nextToken());
			authors.add(author);
		}
		while(st2.hasMoreTokens()) {
			Genre genre = new Genre(st2.nextToken());
			genres.add(genre);
		}
		book.setAuthors(authors);
		book.setGenres(genres);
		book.setTitle(req.getParameter("book_name"));
		Publisher publisher = fetchPublisher(req.getParameter("publisher_name"));
		book.setPublisher(publisher);
		boolean insertBook = new BusinessDelegate().insertBook(book);
		
	}

}
