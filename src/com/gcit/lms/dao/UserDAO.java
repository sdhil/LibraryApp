package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gcit.lms.domain.User;

public class UserDAO {
	
	Connection conn;
	
	public UserDAO(Connection conn) {
		this.conn = conn;
	}
	
	public User getUserByUsername(String username) {
		String sql = "SELECT * FROM tbl_users WHERE username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			User retrieved = null;
			while(rs.next()) {
				retrieved = new User(rs.getString("username"), 
											rs.getString("password"), 
											rs.getInt("role_id"));
			}
			return retrieved;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
