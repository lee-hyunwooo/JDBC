package com.kh.MVC.menu_price;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CafeDAO {
	private Connection connection; 
	String Url = "jdbc:oracle:thin:@localhost:1521:xe";
	String ID = "khcafe";
	String PW = "kh1234";
	public CafeDAO() {
		try {
			connection = DriverManager.getConnection(Url, ID, PW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<CafeDTO> getAllMenus() {
		List<CafeDTO> menus = new ArrayList();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM MENU");
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int MENU_ID = result.getInt("menu_id");
				int CAFE_ID = result.getInt("cafe_id");
				String MENU_NAME = result.getString("menu_name");
				double PRICE = result.getDouble("price");
				String DESCRIPTION = result.getString("description");
			
				CafeDTO menu = new CafeDTO(MENU_ID, CAFE_ID, MENU_NAME, PRICE, DESCRIPTION);
				menus.add(menu);
			}
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
		
	}
	
	
	
	
}
