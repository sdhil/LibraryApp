package com.gcit.lms.dao;

import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.Borrower;
import com.gcit.lms.domain.Branch;
import com.gcit.lms.domain.Genre;
import com.gcit.lms.domain.Publisher;

public class BusinessDelegate {
	private PublisherDAO publisherDAO;
	private BranchDAO branchDAO;
	private BorrowerDAO borrowerDAO;
	private BookDAO bookDAO;
	private AuthorDAO authorDAO;
	private GenreDAO genreDAO;
	
	public BusinessDelegate() {
		publisherDAO = new PublisherDAO();
		branchDAO = new BranchDAO();
		borrowerDAO = new BorrowerDAO();
		bookDAO = new BookDAO();
		authorDAO = new AuthorDAO();
		genreDAO = new GenreDAO();
	}

	public boolean insertPublisher(Publisher publisher) {
		return publisherDAO.insertPublisher(publisher);
	}

	public boolean insertBranch(Branch branch) {
		return branchDAO.insertBranch(branch);
	}

	public boolean insertBorrower(Borrower borrower) {
		return borrowerDAO.insertBorrower(borrower);
	}

	public Publisher fetchPublisher(String name) {
		Publisher retrieved = publisherDAO.getPublisherByName(name);
		return retrieved;
	}

	public boolean insertBook(Book book) {
		return bookDAO.insertBook(book);
	}

	public boolean insertAuthor(Author a) {
		return authorDAO.insertAuthor(a);		
	}

	public boolean insertGenre(Genre g) {
		return genreDAO.insertGenre(g);
	}

}
