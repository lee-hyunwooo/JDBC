package com.kh.db.oracle_sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.sql.DATE;

import java.sql.Date;
public class DBConnection {

	public static void main(String[] args) {
		//selectBank();
		//selectKhcafe();
		//selectIf();
		pr();
	}
			
	static void selectBank() {
		//1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ����Ŭ �� ��ǻ�� ���� : ������ ���̽� ���� ����
		//                               ���� IP�ּ�:��Ʈ��ȣ:SID
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		try {
			//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
			con = DriverManager.getConnection(url, user, password);
			System.out.println("������ ���̽� ���� ����!");
			
			//SELECT ����
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			 //result.next() : result ��ü���� ���� ��(row)���� �̵�
			//�������� ������ true ��ȯ, �׷��� ������ false ��ȯ
			
			//�� ���� ����
			if(!result.isBeforeFirst()) {
				System.out.println("�����ϴ� �����Ͱ� �����ϴ�.");
			}
			while(result.next()) {
				//khbank�� �ִ� bank ���̺� ������տ��� account_id�� ������
				int accountID = result.getInt("account_id");
				//1.�Բ��غ��� : accountNumber
				int accountNumber = result.getInt("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2.�Բ��غ��� : branchName
				String branchName = result.getString("branch_name");
				//java.sql import Date lastTransactionDate��������
				Date lastTransactionDate = result.getDate("last_transaction_date");
				System.out.println("ID : " + accountID + ", NAME : " + accountName + ", balance : " + balance + ", account_number : " + accountNumber + ", branch_Name : " + branchName+ ", lastTransctionDate : " + lastTransactionDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	static void selectKhcafe() {
			//1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
			String driver = "oracle.jdbc.driver.OracleDriver";
			//2. ����Ŭ �� ��ǻ�� ���� : ������ ���̽� ���� ����
			//                               ���� IP�ּ�:��Ʈ��ȣ:SID
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "khcafe";
			String password = "kh1234";
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, user, password);
				System.out.println("������ ���̽� ���� ����!");
				//SELECT ����
				//select * from menu �ۼ��ؼ� menu table ��������
				String selectQuery = "select * from menu";
				PreparedStatement selectState = con.prepareStatement(selectQuery);
				ResultSet result = selectState.executeQuery();
				 //result.next() : result ��ü���� ���� ��(row)���� �̵�
				//�������� ������ true ��ȯ, �׷��� ������ false ��ȯ
				while(result.next()) {
				int menuID = result.getInt("menu_id");
				int cafeID = result.getInt("cafe_id");
				String mName = result.getString("Mname");
				double price = result.getDouble("price");
				String description = result.getString("description");
				System.out.println("menu_id : " + menuID + ", cafe_id : " + cafeID + ", Mname : " + mName + ", price : " + price + ", description : " + description);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	static void selectIf() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//where�� �߰��ؼ� ���� �߰�                             ���������� �����ϱ� ���� "?"
			String selectQuery = "SELECT * FROM BANK WHERE account_id=?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			//���⿡ ���ϴ� ������ account_id ����
			int targetAID = 1;
			
			//���� ����
			selectState.setInt(1, targetAID);
			
			ResultSet result = selectState.executeQuery();
			
		  if (result.next()) {
			  int a = result.getInt("account_id");
			  String b = result.getString("account_number");
			  String c = result.getString("account_name");
			  double d = result.getDouble("balance");
			  String e = result.getString("branch_name");
			  Date f = result.getDate("last_transaction_date");
			  System.out.println("ACCOUNT_ID : " + a + ", ACCOUNT_NUMBER : " + b + ", ACCOUNT_NAME : " + c + ", balance : " + d + " , branch_name" + e + ", last_transaction_date" + f);
		  } else {
			  System.out.println("���ǿ� �ش��ϴ� �����Ͱ� �����ϴ�.");
		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void pr() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		try {
			//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
			con = DriverManager.getConnection(url, user, password);
			
			System.out.println("������ ���̽� ���� ����!");
			
			//SELECT ����
			//String selectQuery = "SELECT * FROM BANK WHERE account_number in(?,?)";
			String selectQuery = "SELECT * FROM BANK WHERE account_number in (?,?,?)";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			String[] targerAN = {"1234567890","1236777888","5555666777"};
			selectState.setString(1, targerAN[0]); //(��¼���, �ε�����)
			selectState.setString(2, targerAN[1]);
			selectState.setString(3, targerAN[2]);
			ResultSet result = selectState.executeQuery();
			 //result.next() : result ��ü���� ���� ��(row)���� �̵�
			//�������� ������ true ��ȯ, �׷��� ������ false ��ȯ
			while(result.next()) {
				//khbank�� �ִ� bank ���̺� ������տ��� account_id�� ������
				int accountID = result.getInt("account_id");
				//1.�Բ��غ��� : accountNumber
				long accountNumber = result.getLong("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2.�Բ��غ��� : branchName
				String branchName = result.getString("branch_name");
				//java.sql import Date lastTransactionDate��������
				Date lastTransactionDate = result.getDate("last_transaction_date");
				System.out.println("ID : " + accountID + ", NAME : " + accountName + ", balance : " + balance + ", account_number : " + accountNumber + ", branch_Name : " + branchName+ ", lastTransctionDate : " + lastTransactionDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
