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
			//인스턴스 생성하여 뷰 초기화
			ProductView view = new ProductView();
			
			//인스턴스 생성하여 컨트롤러 초기화
			ProductController controller = new ProductController(con,view);
			
			//카페 정보 표시하는 메서드 가져오기
			controller.displayAllProducts();
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
