package MVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.BusinessDelegate;
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
		} else {
			req.setAttribute("message", "Something failed. Could not add publisher");
		}
		return false;
	}

}
