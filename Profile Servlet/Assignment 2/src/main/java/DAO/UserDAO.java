package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import bean.User;
import dbConnection.ConnectionManager;

public class UserDAO {
	
	static Connection currentCon = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	public static User login(User bean) {
		// preparing some objects for connection 		
		Statement stmt = null;
		String username = bean.getUsername();
		String password = bean.getPassword();
		String searchQuery = "select * from user where username='" 
		+ username + "' AND password='" + password + "'";
		
		
		// used to trace the process
		System.out.println("in userDAO.login");
		System.out.println("Your user name is " + username);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);
		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			
			
			rs=stmt.executeQuery(searchQuery);
			boolean more=rs.next();

			// if user does not exist
			if (!more) {
				System.out.println("Sorry, you are not a registered user! " + "Please sign up first");
				bean.setValid(false);
			}
			// if user exists
			else if (more) {
				
				String user_Name = rs.getString("username");
				int user_ID = rs.getInt("id");
				String user_Email = rs.getString("email");
				
				
				System.out.println("Welcome " + user_Name);
				
				bean.setName(user_Name);
				bean.setId(user_ID);
				bean.setEmail(user_Email);
				bean.setValid(true);
			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) { }
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) { }
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) { }
				currentCon = null;
			}
		}
		return bean;
	}
	
	public static User register(User bean) {
		// preparing some objects for connection 	
		Statement stmt = null;
		String name = bean.getName();
		String email = bean.getEmail();
		String username = bean.getUsername();
		String password = bean.getPassword();
		//prepare statement
		String searchQuery = "select * from user where username='"+ username +"'";
		
		
		
		String insertQuery = "INSERT INTO `user`(`id`, `name`, `email`, `username`, `password`)"
				+ " VALUES (DEFAULT,'"+ name + "','" + email + "','" 
				+ username +"','"+ password + "')";
		// used to trace the process
		System.out.println("in UserDAO.register");
		System.out.println("Your name is " + name);
		System.out.println("Your email is " + email);
		System.out.println("Your user name is " + username);
		System.out.println("Your password is " + password);
		
		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();  
			
	        //for tracking purpose
	        System.out.println("Search Query: " + searchQuery);
			//execute search query
			rs=stmt.executeQuery(searchQuery);
			boolean more=rs.next();

			// if user does not exist
			if (!more) {
					
			    //for tracking purpose
				System.out.println("Insert Query: " + insertQuery);

				//execute query
				stmt.executeUpdate(insertQuery);
				bean.setValid(true);
				
			}
			// if user exists
			else if (more) {
				
				System.out.println("Account already exist");
				bean.setValid(false);
			}
		} catch (Exception ex) {
			System.out.println("Register failed: An Exception has occurred! " + ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) { }
				rs = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) { }
				currentCon = null;
			}
		}
		return bean;
	}
	
	public static boolean removeUser(String username) {
		boolean clearStatus = false;
		try {
			currentCon = ConnectionManager.getConnection();
			ps = (PreparedStatement) currentCon.prepareStatement("DELETE FROM `user` WHERE username=?");
			ps.setString(1, username);
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected >= 1) {
				clearStatus=true;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				currentCon.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clearStatus;
	}
	
	
}