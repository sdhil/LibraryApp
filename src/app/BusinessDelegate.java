package app;

import domain.Book;
import domain.Borrower;
import domain.Branch;
import domain.Publisher;

public class BusinessDelegate {
	private PublisherDAO publisherDAO;
	private BranchDAO branchDAO;
	private BorrowerDAO borrowerDAO;
	private BookDAO bookDAO;
	
	public BusinessDelegate() {
		publisherDAO = new PublisherDAO();
		branchDAO = new BranchDAO();
		borrowerDAO = new BorrowerDAO();
		bookDAO = new BookDAO();
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

}
