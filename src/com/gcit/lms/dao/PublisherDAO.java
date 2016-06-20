package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.Publisher;

public class PublisherDAO extends BaseDAO{

	public PublisherDAO(Connection conn) {
		super(conn);
	}

	public boolean insertPublisher(Publisher publisher) {
		String sql = "INSERT INTO tbl_publisher(publisherName, publisherAddress, publisherPhone) VALUES(?,?,?)";
		try {
			return save(sql, new Object[]{publisher.getName(), publisher.getAddress(),publisher.getPhone()});
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deletePublisher (Publisher p) {
		String sql = "DELETE FROM tbl_publisher WHERE publisher_id=?";
		try {
			return save(sql, new Object[] { p.getId() });
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public boolean deleteAll() {
		String sql = "DELETE * FROM tbl_publisher";
		try {
			return save(sql, null);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public boolean updatePublisher(Publisher p) {
		String sql = "UPDATE TABLE tbl_publisher SET publisherName = ? WHERE publisherId = ?";
		try {
			return save(sql, new Object[] { p.getName(), p.getId() });
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public List<Publisher> readAll() {
		List<Publisher> list = new ArrayList<Publisher>();
		try {
			list = read("SELECT * FROM tbl_publisher", null);
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public Publisher getPublisherByName(String name) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tbl_publisher WHERE publisherName = ?";
		Publisher publisher = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			while(rs.next()) {
				publisher = new Publisher();
				publisher.setId(rs.getInt("publisherId"));
				publisher.setName(rs.getString("publisherName"));
				publisher.setAddress(rs.getString("publisherAddress"));
				publisher.setPhone(rs.getString("publisherPhone"));
			}
			return publisher;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public List<?> extractData(ResultSet rs) {
		List<Publisher> publishers = new ArrayList<Publisher>();
		BookDAO bdao = new BookDAO(conn);
		try {
			while(rs.next()) {
				Publisher p = new Publisher();
				p.setId(rs.getInt("publisherId"));
				p.setName(rs.getString("publisherName"));
				p.setAddress(rs.getString("publisherAddress"));
				p.setPhone(rs.getString("publisherPhone"));
				List<Book> books = bdao.readFirstLevel("SELECT * FROM tbl_book WHERE pubId = ?", new Object[] { p.getId() });
				if(books != null) {
					p.setBooks(books);
				}
				publishers.add(p);
			}
			return publishers;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public List<?> extractDataFirstLevel(ResultSet rs) {
		List<Publisher> publishers = new ArrayList<Publisher>();
		try {
			while(rs.next()) {
				Publisher p = new Publisher();
				p.setId(rs.getInt("publisherId"));
				p.setName(rs.getString("publisherName"));
				p.setAddress(rs.getString("publisherAddress"));
				p.setPhone(rs.getString("publisherPhone"));
				publishers.add(p);
			}
			return publishers;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
}
