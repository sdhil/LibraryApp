package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection openConnection() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Welcome1");
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
