package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.Genre;
import com.gcit.lms.domain.Publisher;

public class BookDAO extends BaseDAO {

	public BookDAO(Connection conn) {
		super(conn);
	}

	public Integer insertBook(Book book) {
		String sql = "INSERT INTO tbl_book(title, pubId) VALUES(?,?)";
		try {
			return saveWithId(sql, new Object[] { book.getTitle(), book.getPublisher().getId() });
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public boolean deleteBook(Book b) {
		String sql = "DELETE FROM tbl_book WHERE bookId = ?";
		try {
			return save(sql, new Object[] { b.getId() });
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public boolean deleteAll() {
		String sql = "DELETE * FROM tbl_book";
		try {
			return save(sql, null);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public boolean updateBook(Book b) {
		String sql = "UPDATE TABLE tbl_book SET title = ? WHERE bookId = ?";
		try {
			return save(sql, new Object[] { b.getTitle(), b.getId() });
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	public List<Book> readAll() {
		List<Book> list = new ArrayList<Book>();
		try {
			list = read("SELECT * FROM tbl_book", null);
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
	@Override
	public List<Book> extractData(ResultSet rs) {
		List<Book> books = new ArrayList<Book>();
		PublisherDAO pdao = new PublisherDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		GenreDAO gdao = new GenreDAO(conn);
		try {
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("bookId"));
				b.setTitle(rs.getString("title"));
				List<Publisher> pub = pdao.read("SELECT * FROM tbl_publisher "
						+ "WHERE publisherId = ?", new Object[] { rs.getInt("pubId") });
				if (pub != null)
					b.setPublisher(pub.get(0));
				List<Author> auths = adao.readFirstLevel("SELECT * FROM tbl_author "
						+ "WHERE authorId IN (SELECT authorId FROM tbl_book_authors WHERE bookId = ?)", 
						new Object[] { b.getId() });
				if(auths != null)
					b.setAuthors(auths);
				List<Genre> gens = gdao.readFirstLevel("SELECT * FROM tbl_genre "
						+ "WHERE genre_id IN (SELECT genre_id FROM tbl_book_genres WHERE bookId = ?)", 
						new Object[] { b.getId() });
				if (gens != null)
					b.setGenres(gens);
				books.add(b);
			}
			return books;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public List<?> extractDataFirstLevel(ResultSet rs) {
		List<Book> books = new ArrayList<Book>();
		try {
			while(rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("bookId"));
				b.setTitle(rs.getString("title"));
				Publisher p = new Publisher();
				p.setId(rs.getInt("pubId"));
				b.setPublisher(p);
				books.add(b);
			}
			return books;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
