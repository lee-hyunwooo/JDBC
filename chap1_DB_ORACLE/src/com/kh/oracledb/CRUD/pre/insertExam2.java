package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertExam2 {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String passwore = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, passwore);
			String insertSQL = "INSERT INTO MENU (MENU_ID, CAFE_ID, MNAME, PRICE, DESCRIPTION)"
								+ "VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			insertmenu(ps, 30, 15, "레몬차", 4.50, "상큼한 레몬차");
			
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	static void insertmenu(PreparedStatement ps, int MENU_ID, int CAFE_ID, String MNAME, double PRICE, String DESCRIPTION) throws SQLException {
		ps.setInt(1, MENU_ID);
		ps.setInt(2, CAFE_ID);
		ps.setNString(3, MNAME);
		ps.setDouble(4, PRICE);
		ps.setString(5, DESCRIPTION);
		
		ps.executeUpdate();
	}

	


}