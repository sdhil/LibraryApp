package domain;

public class Borrower {
	int cardNo;
	String name;
	String address;
	String phone;
	
	public Borrower() {
		
	}

	public Borrower(int cardNo, String name, String address, String phone) {
		super();
		this.cardNo = cardNo;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public Borrower(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
