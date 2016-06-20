package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.Genre;

public class GenreDAO extends BaseDAO {

	public GenreDAO(Connection conn) {
		super(conn);
	}

	public boolean insertGenre(Genre g) {
		String sql = "INSERT INTO tbl_genre(genre_name) VALUES(?)";
		try {
			return save(sql, new Object[] { g.getName() });
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	public boolean deleteGenre(Genre g) {
		String sql = "DELETE FROM tbl_genre WHERE genre_id=?";
		try {
			return save(sql, new Object[] { g.getId() });
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public boolean deleteAll() {
		String sql = "DELETE * FROM tbl_genre";
		try {
			return save(sql, null);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public boolean updateGenre(Genre g) {
		String sql = "UPDATE TABLE tbl_genre SET genre_name = ? WHERE genre_id = ?";
		try {
			return save(sql, new Object[] { g.getName(), g.getId() });
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public List<Genre> readAll() {
		List<Genre> list = new ArrayList<Genre>();
		try {
			list = read("SELECT * FROM tbl_genre", null);
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public List<?> extractData(ResultSet rs) {
		List<Genre> genres = new ArrayList<Genre>();
		BookDAO bookDAO = new BookDAO(conn);
		try {
			while(rs.next()) {
				Genre g = new Genre();
				g.setId(rs.getInt("genre_id"));
				g.setName(rs.getString("genre_name"));
				List<Book> books = bookDAO.readFirstLevel("SELECT * FROM tbl_book WHERE bookId IN (SELECT bookId FROM tbl_book_genres WHERE genre_id = ?)", new Object[] { g.getId() });
				g.setBooks(books);
				genres.add(g);
			}
			return genres;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public List<?> extractDataFirstLevel(ResultSet rs) {
		List<Genre> genres = new ArrayList<Genre>();
		try {
			while (rs.next()) {
				Genre g = new Genre();
				g.setId(rs.getInt("genre_id"));
				g.setName(rs.getString("genre_name"));
				genres.add(g);
			}
			return genres;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

}
