package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Publisher;

public class PublisherDAO {
	
	private Connection conn;
	
	public PublisherDAO() {
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
	

	public boolean insertPublisher(Publisher publisher) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO tbl_publisher(publisherName, publisherAddress, publisherPhone) VALUES(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, publisher.getName());
			stmt.setString(2, publisher.getAddress());
			stmt.setString(3, publisher.getPhone());
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
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return false;
	}
	
	public Publisher getPublisherByName(String name) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tbl_publisher WHERE publisherName = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			Publisher publisher = null;
			while(rs.next()) {
				publisher = new Publisher();
				publisher.setId(rs.getInt("publisherId"));
				publisher.setName(rs.getString("publisherName"));
				publisher.setAddress(rs.getString("publisherAddress"));
				publisher.setPhone(rs.getString("publisherPhone"));
			}
			return publisher;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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
