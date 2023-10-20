package com.kh.MainSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.kh.ControllerSample.ProductController;
import com.kh.MVC.Singleton.Product.ProductView;

public class ProductMain {

	public static void main(String[] args) {

		String jdbc_oracle_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String passwore = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbc_oracle_url, username, passwore);
			//�ν��Ͻ� �����Ͽ� �� �ʱ�ȭ
			ProductView view = new ProductView();
			
			//�ν��Ͻ� �����Ͽ� ��Ʈ�ѷ� �ʱ�ȭ
			ProductController controller = new ProductController(con,view);
			
			//ī�� ���� ǥ���ϴ� �޼��� ��������
			controller.displayAllProducts();
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
