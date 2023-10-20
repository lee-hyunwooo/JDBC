package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductsMain {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String passwore = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, username, passwore);
			//�ν��Ͻ� �����Ͽ� �� �ʱ�ȭ
			ProductsView view = new ProductsView();
			
			//�ν��Ͻ� �����Ͽ� ��Ʈ�ѷ� �ʱ�ȭ
			ProductsController controller = new ProductsController(con,view);
			
			//ī�� ���� ǥ���ϴ� �޼��� ��������
			controller.displayAllProducts();
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
