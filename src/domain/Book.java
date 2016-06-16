package domain;

import java.util.List;

public class Book {
	int id;
	String title;
	Publisher publisher;
	List authors;
	List genres;
	
	public Book() {
		
	}
		
	public Book(String title, Publisher publisher, List authors, List genres) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.authors = authors;
		this.genres = genres;
	}

	public Book(int id, String title, Publisher publisher, List authors, List genres) {
		super();
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.authors = authors;
		this.genres = genres;
	}

	public List getAuthors() {
		return authors;
	}

	public void setAuthors(List authors) {
		this.authors = authors;
	}

	public List getGenres() {
		return genres;
	}

	public void setGenres(List genres) {
		this.genres = genres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
}
