package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.Genre;

public class BookGenreDAO extends BaseDAO{

	public BookGenreDAO(Connection conn) {
		super(conn);
	}

	public boolean insertBookGenre(Book book) {
		for(Genre g : book.getGenres()) {
			String sql = "INSERT INTO tbl_book_genres(genre_id, bookId) VALUES(?,?)";
			try {
				save(sql, new Object[] {g.getId(), book.getId()});
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
