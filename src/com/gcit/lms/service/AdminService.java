package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookAuthorDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookGenreDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.ConnectionFactory;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.dao.UserDAO;
import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.Borrower;
import com.gcit.lms.domain.Branch;
import com.gcit.lms.domain.Genre;
import com.gcit.lms.domain.Publisher;
import com.gcit.lms.domain.User;

public class AdminService {
	
	public User login(String username, String password) {
		Connection conn = ConnectionFactory.openConnection();
		UserDAO uDAO = new UserDAO(conn);
		return uDAO.getUserByUsername(username);
	}


	public boolean insertBranch(Branch branch) {
		Connection conn = ConnectionFactory.openConnection();
		BranchDAO bDAO = new BranchDAO(conn);
		try {
			if (bDAO.insertBranch(branch)) {
				conn.commit();
				return true;
			} else {
				conn.rollback();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean insertBorrower(Borrower borrower) {
		Connection conn = ConnectionFactory.openConnection();
		BorrowerDAO bDAO = new BorrowerDAO(conn);
		try {
			if (bDAO.insertBorrower(borrower)) {
				conn.commit();
				return true;
			} else {
				conn.rollback();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean insertPublisher(Publisher publisher) {
		Connection conn = ConnectionFactory.openConnection();
		PublisherDAO pDAO = new PublisherDAO(conn);
		try {
			if (pDAO.insertPublisher(publisher)) {
				conn.commit();
				return true;
			} else {
				conn.rollback();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Publisher> getAllPublishers() {
		Connection conn = ConnectionFactory.openConnection();
		PublisherDAO pDAO = new PublisherDAO(conn);
		try {
			return pDAO.readAll();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean insertBook(Book book) {
		Connection conn = ConnectionFactory.openConnection();
		BookDAO bDAO = new BookDAO(conn);
		BookAuthorDAO baDAO = new BookAuthorDAO(conn);
		BookGenreDAO bgDAO = new BookGenreDAO(conn);
		try {
			Integer bookId = bDAO.insertBook(book);
			boolean insertBook;
			if (bookId != null) {
				book.setId(bookId);
				insertBook = true;
			} else {
				insertBook = false;
			}
			boolean insertBookAuthor = baDAO.insertBookAuthor(book);
			boolean insertBookGenre = bgDAO.insertBookGenre(book);
			if (insertBook && insertBookAuthor && insertBookGenre) {
				conn.commit();
				return true;
			} else {
				conn.rollback();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean insertAuthor(Author a) {
		Connection conn = ConnectionFactory.openConnection();
		AuthorDAO adao = new AuthorDAO(conn);
		try {
			if (adao.insertAuthor(a)) {
				conn.commit();
				return true;
			} else {
				conn.rollback();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Author> getAllAuthors() {
		Connection conn = ConnectionFactory.openConnection();
		AuthorDAO adao = new AuthorDAO(conn);
		try {
			return adao.readAll();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean insertGenre(Genre g) {
		Connection conn = ConnectionFactory.openConnection();
		GenreDAO gDAO = new GenreDAO(conn);
		try {
			if (gDAO.insertGenre(g)) {
				conn.commit();
				return true;
			} else {
				conn.rollback();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public List<Genre> getAllGenres() {
		Connection conn = ConnectionFactory.openConnection();
		GenreDAO gDAO = new GenreDAO(conn);
		try {
			return gDAO.readAll();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Book> getAllBooks() {
		Connection conn = ConnectionFactory.openConnection();
		BookDAO bDAO = new BookDAO(conn);
		try {
			return bDAO.readAll();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
