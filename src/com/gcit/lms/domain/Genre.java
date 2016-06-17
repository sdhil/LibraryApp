package com.gcit.lms.domain;

import java.io.Serializable;

public class Genre implements Serializable{
	
	private static final long serialVersionUID = 7922025997056558559L;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Genre other = (Genre) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
