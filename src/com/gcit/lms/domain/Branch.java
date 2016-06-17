package com.gcit.lms.domain;

import java.io.Serializable;

public class Branch implements Serializable{
	
	private static final long serialVersionUID = 3117262791651841917L;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchAddress == null) ? 0 : branchAddress.hashCode());
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		if (branchAddress == null) {
			if (other.branchAddress != null)
				return false;
		} else if (!branchAddress.equals(other.branchAddress))
			return false;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
