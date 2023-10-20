package com.kh.MainSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.kh.ControllerSample.CafeController;
import com.kh.viewSample.CafeView;

public class CafeMain {

	public static void main(String[] args) {
		//connection �� ������ ���� �ۼ�
		//url username password
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			//�ν��Ͻ� �����Ͽ� �� �ʱ�ȭ
			CafeView view = new CafeView();
			
			//�ν��Ͻ� �����Ͽ� ��Ʈ�ѷ� �ʱ�ȭ
			CafeController controller = new CafeController(con,view);
			
			//ī�� ���� ǥ���ϴ� �޼��� ��������
			controller.displayAllCafes();
			
			//connection.close()
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
