package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Borrower;

public class BorrowerDAO extends BaseDAO{
	
	public BorrowerDAO(Connection conn) {
		super(conn);
	}

	public boolean insertBorrower(Borrower borrower) {
		String sql = "INSERT INTO tbl_borrower(name, address, phone) VALUES(?,?,?)";
		try {
			return save(sql, new Object[] {borrower.getName(), borrower.getAddress(), borrower.getPhone()});
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<?> extractData(ResultSet rs) throws SQLException {
		List<Borrower> borrowers = new ArrayList<Borrower>();
		while(rs.next()) {
			Borrower b = new Borrower();
			b.setCardNo(rs.getInt("cardNo"));
			b.setName(rs.getString("name"));
			b.setAddress(rs.getString("address"));
			b.setPhone(rs.getString("phone"));
			borrowers.add(b);
		}
		return borrowers;
	}

	@Override
	public List<?> extractDataFirstLevel(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
