package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gcit.lms.domain.Book;

public class BookDAO {
	private Connection conn;
	
	public BookDAO() {
		conn = ConnectionFactory.openConnection();
	}
	
	public void close() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean insertBook(Book book) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO tbl_book(title, pubId) VALUES(?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setInt(2, book.getPublisher().getId());	
			int rows = stmt.executeUpdate();
			if(rows==1) {
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
	
	
}
