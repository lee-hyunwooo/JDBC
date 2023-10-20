package com.kh.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProductModel {

	private static Connection connection;
	//Ŭ������ �ν��Ͻ��� �����ϴ� �̱��� ��ü
	private static UpdateProductModel productmodel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "kh1234";
	
	//�⺻ �����ڷκ��� �ܺο��� �ν��Ͻ��� ���� �����ϴ°��� �����ϱ�����private ����
	private UpdateProductModel() {
		
	}
	public static UpdateProductModel getInstance() throws SQLException {
		if(productmodel == null /*/null���� �� �����ϰڴ�*/) {
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
			
			int a =st.executeUpdate();//���� �Է°��� ��� �ùٸ��� ���� executeUpdate�� ���ప�� 1�̵Ǿ� ���
			return a > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
}
