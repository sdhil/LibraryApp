package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class BaseDAO {
		
	public boolean save(String sql, Object[] vals) {
		PreparedStatement stmt = null;
		Connection conn = ConnectionFactory.openConnection();
		try {
			stmt = conn.prepareStatement(sql);
			if(vals != null) {
				int count = 1;
				for(Object o : vals) {
					stmt.setObject(count, o);
					count++;
				}
			}
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
