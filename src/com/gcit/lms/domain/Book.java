package com.gcit.lms.domain;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable{
	
	private static final long serialVersionUID = 986306188507292654L;
	int id;
	String title;
	Publisher publisher;
	List<Author> authors;
	List<Genre> genres;
	
	public Book() {
		
	}
		
	public Book(String title, Publisher publisher, List<Author> authors, List<Genre> genres) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.authors = authors;
		this.genres = genres;
	}

	public Book(int id, String title, Publisher publisher, List<Author> authors, List<Genre> genres) {
		super();
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.authors = authors;
		this.genres = genres;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + id;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (id != other.id)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
