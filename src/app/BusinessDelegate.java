package app;

import domain.Publisher;

public class BusinessDelegate {
	private PublisherDAO publisherDAO;
	
	public BusinessDelegate() {
		publisherDAO = new PublisherDAO();
	}

	public boolean insertPublisher(Publisher publisher) {
		return publisherDAO.insertPublisher(publisher);
	}

}
