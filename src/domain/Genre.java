package domain;

public class Genre {
	int id;
	String name;
	
	public Genre() {
		
	}

	public Genre(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Genre(String name) {
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
