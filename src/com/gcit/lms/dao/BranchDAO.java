package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Branch;

public class BranchDAO extends BaseDAO{
		
	public BranchDAO(Connection conn) {
		super(conn);
	}

	public boolean insertBranch(Branch branch) {

		String sql = "INSERT INTO tbl_library_branch(branchName, branchAddress) VALUES(?,?)";
		try {
			return save(sql, new Object[] {branch.getBranchName(), branch.getBranchAddress()});
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<?> extractData(ResultSet rs) throws SQLException {
		List<Branch> branches = new ArrayList<Branch>();
		while(rs.next()) {
			Branch b = new Branch();
			b.setId(rs.getInt("branchId"));
			b.setBranchName(rs.getString("branchName"));
			b.setBranchAddress(rs.getString("branchAddress"));
			branches.add(b);
		}
		return branches;
	}

	@Override
	public List<?> extractDataFirstLevel(ResultSet rs) throws SQLException {
		return null;
	}

}
