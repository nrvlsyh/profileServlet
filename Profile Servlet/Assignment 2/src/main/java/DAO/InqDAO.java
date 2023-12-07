package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import bean.User;
import bean.Inquiry;
import dbConnection.ConnectionManager;

public class InqDAO {
	
	static Connection currentCon = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	public static boolean addInq(Inquiry newInq) {
		
		boolean insertStatus = false;
		try {
			currentCon = ConnectionManager.getConnection();
			ps = (PreparedStatement) currentCon.prepareStatement("INSERT INTO `inquiry`(`name`, `email`, `message`) "
					+ "VALUES (?,?,?)");
			ps.setString(1, newInq.getName());
			ps.setString(2, newInq.getEmail());
			ps.setString(3, newInq.getMessage());
			
			int rowsAffected = ps.executeUpdate();
				
			if(rowsAffected == 1) {
				insertStatus = true;
				ResultSet tableKeys = ps.getGeneratedKeys();
				tableKeys.next();
				newInq.setId(tableKeys.getInt(1));
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
		return insertStatus;
	

	}
	
	public static List<Inquiry> getAll() {
		List<Inquiry> inqList = new ArrayList<Inquiry>();
		
		try {
			
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from inquiry order by id");
			
			while(rs.next()) {
				Inquiry iq = new Inquiry();
				iq.setId(rs.getInt("id"));
				iq.setName(rs.getString("name"));
				iq.setEmail(rs.getString("email"));
				iq.setMessage(rs.getString("message"));
				inqList.add(iq);
			}
		}
		catch (SQLException e) { 
			  e.printStackTrace(); 
		}
		
		return inqList;
	}
}
	
