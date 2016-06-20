package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class BaseDAO {

	Connection conn;

	public BaseDAO(Connection conn) {
		this.conn = conn;
	}

	public boolean save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(sql);
		if (vals != null) {
			int count = 1;
			for (Object o : vals) {
				stmt.setObject(count, o);
				count++;
			}
		}
		int rows = stmt.executeUpdate();
		if (rows > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Integer saveWithId(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		if (vals != null) {
			int count = 1;
			for (Object o : vals) {
				stmt.setObject(count, o);
				count++;
			}
		}
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			return rs.getInt(1);
		} else {
			return null;
		}
	}

	public <T> List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			stmt = conn.prepareStatement(sql);
			if (vals != null) {
				int count = 1;
				for (Object o : vals) {
					stmt.setObject(count, o);
					count++;
				}
			}
			rs = stmt.executeQuery();
			list = (List<T>) extractData(rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public abstract List<?> extractData(ResultSet rs) throws SQLException;

	public <T> List<T> readFirstLevel(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			stmt = conn.prepareStatement(sql);
			if (vals != null) {
				int count = 1;
				for (Object o : vals) {
					stmt.setObject(count, o);
					count++;
				}
			}
			rs = stmt.executeQuery();
			list = (List<T>) extractDataFirstLevel(rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public abstract List<?> extractDataFirstLevel(ResultSet rs) throws SQLException;
}
