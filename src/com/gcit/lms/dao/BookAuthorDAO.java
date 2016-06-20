package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;

public class BookAuthorDAO extends BaseDAO{

	public BookAuthorDAO(Connection conn) {
		super(conn);
	}

	public boolean insertBookAuthor(Book book) {
		for(Author a : book.getAuthors()) {
			String sql = "INSERT INTO tbl_book_authors(bookId, authorId) VALUES(?,?)";
			try {
				save(sql, new Object[] { book.getId(), a.getId() });
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	@Override
	public List<?> extractData(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> extractDataFirstLevel(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
