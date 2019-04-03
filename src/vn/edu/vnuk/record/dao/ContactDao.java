package vn.edu.vnuk.record.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import vn.edu.vnuk.jdbc.ConnectionFactory;
import vn.edu.vnuk.record.model.Contact;

public class ContactDao {
	private Connection connection; 
	
	public ContactDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void create(Contact contact) throws SQLException {
		
		String sqlQuery = "insert into contacts (name, email, address, date_of_register) "
                +	"values (?, ?, ?, ?)";
		
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(sqlQuery);

            //	Replacing "?" through values
            statement.setString(1, contact.getName());
            statement.setString(2, contact.getEmail());
            statement.setString(3, contact.getAddress());
            statement.setDate(4, new java.sql.Date(
                            contact.getDateOfRegister().getTimeInMillis()));

            // 	Executing statement
			statement.execute();
			statement.close();
	        System.out.println("   DATA successfully loaded in \'categories\'");
		
		}
		
		catch (Exception e) {
	        e.printStackTrace();
	        connection.close();
		}
		
		finally {
			System.out.println("<  Sql5010InsertIntoCategories ended");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("");
		}
			
	}
@SuppressWarnings("finally")
public List<Contact> read() throws SQLException{
		
		PreparedStatement statement;
		String sqlQuery = "select * from contacts";
		List<Contact> contacts = new ArrayList<Contact>();
		
		try {
			statement = connection.prepareStatement(sqlQuery);

            // 	Executing statement
			ResultSet results = statement.executeQuery();
			
			while (results.next()) {
				contacts.add(buildContact(results));
			}
			
			results.close();
			statement.close();
			
			
		}
		
		catch (Exception e) {
	        e.printStackTrace();
	        connection.close();
		}
		
		finally {
	
			connection.close();
			return contacts;
		}
	}

	private Contact buildContact(ResultSet results) throws SQLException {
		Contact contact = new Contact();
		contact.setId(results.getLong("id"));
		contact.setName(results.getString("name"));
		contact.setAddress(results.getString("address"));
		contact.setEmail(results.getString("email"));
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(results.getDate("date_of_register"));
		contact.setDateOfRegister(calendar);
		return contact;
	}
	
	@SuppressWarnings("finally")
	public Contact read (Long id) throws SQLException{
		String sqlQuery = "Select * from contacts where id =" + id + ";";
		PreparedStatement statement;
		Contact contact = new Contact();
		try {
			statement = connection.prepareStatement(sqlQuery);

            // 	Executing statement
			ResultSet results = statement.executeQuery();
			
			if (results.next()) {
				contact = buildContact(results);
			}
			
			results.close();
			statement.close();
			
			
		}
		
		catch (Exception e) {
	        e.printStackTrace();
	        connection.close();
		}
		
		finally {
			return contact;
		}
	}
	@SuppressWarnings({ "finally", "unused" })
	public Contact delete (Long id) throws SQLException{
		String sqlQuery = "Delete from contacts where id =" + id + ";";
		PreparedStatement statement;
		Contact contact = new Contact();
		
		try {
			contact = read(id);
			statement = connection.prepareStatement(sqlQuery);
			int checkId = statement.executeUpdate();
			if ( checkId != 0) {
				System.out.println("Deleted ID : " + checkId );
			}
			else {
				System.out.println("Id not EXISTS");
			}
			
			
			
			statement.close();
			
			
		}
		
		catch (Exception e) {
	        e.printStackTrace();
	        connection.close();
		}
		
		finally {
	
			connection.close();
			return contact;
		}
	}
	public void update(Long id, Contact nContact) throws SQLException {
		
		Contact contact = new Contact();
		
		String sqlQuery = "update contacts set name = ?, email = ?, address = ? where id = " + id;
		
		PreparedStatement statement;
		
		try {
			contact = read(id);
			statement = connection.prepareStatement(sqlQuery);
			
			statement.setString(1, nContact.getName());
			statement.setString(2, nContact.getEmail());
			statement.setString(3, nContact.getAddress());
				
			if(contact != null) {
				int rowsUpdated = statement.executeUpdate();
				
				if(rowsUpdated > 0) {
					System.out.println("Updated ID : " + id);
				} else {
					System.out.println("Id not EXISTS");
				}
			} else {
				System.out.println("Id not EXISTS");
			}
			
			statement.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			connection.close();	
		}
		
		finally {
			connection.close();
		}		
	}
}
