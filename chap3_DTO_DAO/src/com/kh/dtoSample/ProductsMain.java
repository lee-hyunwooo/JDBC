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
			//인스턴스 생성하여 뷰 초기화
			ProductsView view = new ProductsView();
			
			//인스턴스 생성하여 컨트롤러 초기화
			ProductsController controller = new ProductsController(con,view);
			
			//카페 정보 표시하는 메서드 가져오기
			controller.displayAllProducts();
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
