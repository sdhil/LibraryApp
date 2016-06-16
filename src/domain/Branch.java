package domain;

public class Branch {
	int id;
	String branchName;
	String branchAddress;
	
	public Branch() {
		
	}
	
	public Branch(String branchName, String branchAddress) {
		super();
		this.branchName = branchName;
		this.branchAddress = branchAddress;
	}

	public Branch(int id, String branchName, String branchAddress) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
}
