package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "kh1234";
	public void insertCafe(String name, String address, String phone_number, String operating_hours) {
	try {
		Connection con = DriverManager.getConnection(url, username, password);
		String sql = "INSERT INTO CAFES (CNAME, ADDRESS,PHONE_NUMBER,OPERATING_HOURS)"
						+ "VALUES (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setString(3, phone_number);
		ps.setString(4, operating_hours);
		
		ps.executeUpdate();
		
	
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}

	public void UpdateCafe(/*매개변수 추가하기*/String operating_hours, int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE cafes SET operating_hours = ? WHERE cafe_id = ?";
			PreparedStatement pp = con.prepareStatement(sql);
			pp.setString(1, operating_hours);
			pp.setInt(2, cafe_id);
			
			pp.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void UpdateMenu(String description, int menuID, int cafeID) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE menu SET DESCRIPTION = ? WHERE menu_id = ? AND cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, description);
			st.setInt(2, menuID);
			st.setInt(3, cafeID);
			
			st.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteCafe (/*매개변수자리*/int cafeID) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM cafes WHERE cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cafeID);
			
			st.executeUpdate();
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void DeleteMenu(/*파라미터(매개변수) 추가*/int menu_id) {
		try {
			Connection con =DriverManager.getConnection(url, username, password);
			String sql = "DELETE FORM MENU WHERE MENU_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, menu_id);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void DeleteOrder(int CAFE_id) {
		try {
			Connection con =DriverManager.getConnection(url, username, password);
			String sql = "DELETE FORM ORDERS WHERE CAFE_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, CAFE_id);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}