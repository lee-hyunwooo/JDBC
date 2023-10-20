package com.kh.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProductModel {

	private static Connection connection;
	//클래스의 인스턴스를 저장하는 싱글톤 객체
	private static UpdateProductModel productmodel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "kh1234";
	
	//기본 생성자로부터 외부에서 인스턴스를 직접 생성하는것을 방지하기위해private 선언
	private UpdateProductModel() {
		
	}
	public static UpdateProductModel getInstance() throws SQLException {
		if(productmodel == null /*/null값일 때 실행하겠다*/) {
			productmodel = new UpdateProductModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
		}
		return productmodel;
	}
	public boolean updeateProduct(ProductDTO product) {
		String sql = "UPDATE products SET price = ? WHERE product_id = ?";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setDouble(1, product.getPrice());
			st.setInt(2, product.getProduct_id());
			
			int a =st.executeUpdate();//위에 입력값이 모두 올바르게 들어가야 executeUpdate의 수행값이 1이되어 통과
			return a > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
}
