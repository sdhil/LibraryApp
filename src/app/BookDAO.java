package app;

import java.sql.Connection;
import java.sql.SQLException;

import domain.Book;

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
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
