package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Branch;

public class BranchDAO {
	
	private Connection conn;
	
	public BranchDAO() {
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

	public boolean insertBranch(Branch branch) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO tbl_library_branch(branchName, branchAddress) VALUES(?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, branch.getBranchName());
			stmt.setString(2, branch.getBranchAddress());
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

}
