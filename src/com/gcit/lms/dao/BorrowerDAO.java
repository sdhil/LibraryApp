package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gcit.lms.domain.Borrower;

public class BorrowerDAO {
	
	Connection conn;
	
	public BorrowerDAO() {
		conn = ConnectionFactory.openConnection();
	}

	public boolean insertBorrower(Borrower borrower) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO tbl_borrower(name, address, phone) VALUES(?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, borrower.getName());
			stmt.setString(2, borrower.getAddress());
			stmt.setString(3, borrower.getPhone());
			int rows = stmt.executeUpdate();
			if(rows == 1) {
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
