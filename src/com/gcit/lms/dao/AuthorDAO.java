package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;

public class AuthorDAO extends BaseDAO {

	public AuthorDAO(Connection conn) {
		super(conn);
	}

	public boolean insertAuthor(Author a) {
		String sql = "INSERT INTO tbl_author(authorName) VALUES (?)";
		try {
			return save(sql, new Object[] { a.getName() });
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	public boolean deleteAuthor(Author a) {
		String sql = "DELETE FROM tbl_author WHERE authorId=?";
		try {
			return save(sql, new Object[] { a.getId() });
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	public boolean deleteAll() {
		String sql = "DELETE * FROM tbl_author";
		try {
			return save(sql, null);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	public boolean updateAuthor(Author a) {
		String sql = "UPDATE TABLE tbl_author SET authorName = ? WHERE authorId = ?";
		try {
			return save(sql, new Object[] { a.getName(), a.getId() });
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	public List<Author> readAll() {
		List<Author> authors = new ArrayList<Author>();
		try {
			authors = read("SELECT * FROM tbl_author", null);
			return authors;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public List<?> extractData(ResultSet rs) {
		List<Author> authors = new ArrayList<Author>();
		BookDAO bdao = new BookDAO(conn);
		try {
			while (rs.next()) {
				Author a = new Author();
				a.setId(rs.getInt("authorId"));
				a.setName(rs.getString("authorName"));
				List<Book> books = bdao.readFirstLevel(
						"SELECT * FROM tbl_book WHERE bookId IN (SELECT bookId from tbl_book_authors WHERE authorId = ?)",
						new Object[] { a.getId() });
				if (books != null)
					a.setBooks(books);
				authors.add(a);
			}
			return authors;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public List<?> extractDataFirstLevel(ResultSet rs) {
		List<Author> authors = new ArrayList<Author>();
		try {
			while (rs.next()) {
				Author a = new Author();
				a.setId(rs.getInt("authorId"));
				a.setName(rs.getString("authorName"));
				authors.add(a);
			}
			return authors;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
}
