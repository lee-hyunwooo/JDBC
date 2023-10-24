package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO {
	private Connection connection;
	String Url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "kh1234";
	
	public OrdersDAO() {
		try {
			connection = DriverManager.getConnection(Url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<OrdersDTO> getAllOrders() {
		List<OrdersDTO> orders = new ArrayList();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM ORDERS ");
			ResultSet result = st.executeQuery();
		
			while(result.next()) {
				int order_id = result.getInt("order_id");
				int cafe_id = result.getInt("cafe_id"); 
				int menu_id = result.getInt("menu_id");
				String order_date = result.getString("order_date");
				int quantity = result.getInt("quantity");
				double total_price = result.getDouble("total_price");
			
				OrdersDTO order = new OrdersDTO(order_id, cafe_id, menu_id, order_date, quantity, total_price);
						orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
}
