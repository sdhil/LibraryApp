package domain;

public class Author {
	int id;
	String name;
	
	public Author() {
		
	}

	public Author(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Author(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
