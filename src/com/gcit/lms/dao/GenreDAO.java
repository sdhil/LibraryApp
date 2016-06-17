package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gcit.lms.domain.Genre;

public class GenreDAO {
	
	Connection conn;
	
	public GenreDAO() {
		conn = ConnectionFactory.openConnection();
	}

	public boolean insertGenre(Genre g) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO tbl_genre(genre_name) VALUES(?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, g.getName());
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
