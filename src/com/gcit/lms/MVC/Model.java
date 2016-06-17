package com.gcit.lms.MVC;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.lms.dao.BusinessDelegate;
import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.Borrower;
import com.gcit.lms.domain.Branch;
import com.gcit.lms.domain.Genre;
import com.gcit.lms.domain.Publisher;

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
		for(Author a : authors) {
			boolean insertAuthor = new BusinessDelegate().insertAuthor(a);
			if(!insertAuthor) {
				req.setAttribute("message", "Error! Could not add authors");
				return false;
			}
		}
		while(st2.hasMoreTokens()) {
			Genre genre = new Genre(st2.nextToken());
			genres.add(genre);
		}
		for(Genre g : genres) {
			boolean insertGenre = new BusinessDelegate().insertGenre(g);
			if(!insertGenre) {
				req.setAttribute("message", "Error! Could not add genres");
				return false;
			}
		}
		book.setAuthors(authors);
		book.setGenres(genres);
		book.setTitle(req.getParameter("book_name"));
		Publisher publisher = fetchPublisher(req.getParameter("publisher_name"));
		book.setPublisher(publisher);
		boolean insertBook = new BusinessDelegate().insertBook(book);
		if(insertBook) {
			req.setAttribute("message", "Successfully added the book and its authors and genres");
			return true;
		} else {
			req.setAttribute("message", "Something failed!");
			return false;
		}
	}

}
