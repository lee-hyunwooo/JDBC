package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.sql.DATE;

import java.sql.Date;
public class InsertSample {

	public static void main(String[] args) {
		//selectBank();
		//selectKhcafe();
		//selectIf();
		//pr();
		//pr2();
		//pr3();
		//insertBank();
		//insertKhcafe();
		insertKhcafe4();
	
	}
			
	static void selectBank() {
		//1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ����Ŭ �� ��ǻ�� ���� : ������ ���̽� ���� ����
		//thin�� ����̹��� ������ ��          ���� IP�ּ�:��Ʈ��ȣ:SID
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

	static void pr2() {
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
			//                                                                 (?)������ŭ �˻������ϸ�, �˻��� ������ŭ ���
			String selectQuery = "SELECT * FROM BANK WHERE account_name in (?,?,?)";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			String[] targerAN = {"������","�迵��","�̵���"};
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
	
	static void pr3() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("���Ἲ��");
			
			String selectQurty = "SELECT * FROM CAFES WHERE operating_hours in (?,?)";
			PreparedStatement selectState = con.prepareStatement(selectQurty);
			
			String[] targethours = {"����: 07:00-20:30", "����: 09:30-20:00"};
			selectState.setString(1, targethours[0]);
			selectState.setString(2, targethours[1]);
			
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				//khbank�� �ִ� bank ���̺� ������տ��� account_id�� ������
				int CAFEID = result.getInt("CAFE_ID");
				//1.�Բ��غ��� : accountNumber
				String CNAME = result.getString("CNAME");
				String address = result.getString("address");
				String PhoneNumber = result.getString("PHONE_NUMBER");
				//2.�Բ��غ��� : branchName
				String operating_hours = result.getString("operating_hours");
				System.out.println("ID : " + CAFEID + ", NAME : " + CNAME + ", address : " + address + ", PHONE_NUMBER : " + PhoneNumber + ", operating_hours : " + operating_hours);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void insertBank() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String inserQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
								+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement insertState = con.prepareStatement(inserQuery);
			insertState.setInt(1, 14);
			insertState.setString(2, "16533219");
			insertState.setString(3, "�����");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5,  "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row �߰���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void insertKhcafe() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			//insert�� �ۼ��غ���
			String insertQuery = "INSERT INTO CAFES (CAFE_ID, CNAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS)"
								+ "VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 41);
			insertState.setString(2, "Ŀ��û");
			insertState.setString(3, "����� ���� ������ 11");
			insertState.setString(4, "000-888-7777");
			insertState.setString(5, "���� : 09:00-20:30");
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row �߰���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	static void insertKhcafe2() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO MENU (MENU_ID, CAFE_ID, MNAME, PRICE, DESCRIPTION)"
								+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 27);
			insertState.setInt(2, 14);
			insertState.setString(3, "���ǳӶ�");
			insertState.setDouble(4, 3.80);
			insertState.setString(5, "����� ǳ���� ��");
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row �߰���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	static void insertKhcafe3() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO MENU (MENU_ID, CAFE_ID, MNAME, PRICE, DESCRIPTION)"
									+ "VALUES (?,?,?,?,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			
			insertState.setInt(1, 28);
			insertState.setInt(2, 12);
			insertState.setString(3, "��������");
			insertState.setDouble(4, 5.30);
			insertState.setString(5, "�ε巯�� ���̽�ũ���� �ö� Ŀ��");
			
			int rowsinto = insertState.executeUpdate();
			System.out.println(rowsinto + "row ������");
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	static void insertKhcafe4() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con =DriverManager.getConnection(url, user, password);
			
			String insertQuery = "INSERT INTO MENU (MENU_ID, CAFE_ID, MNAME, PRICE, DESCRIPTION)"
								+ "VALUES (?,?,?,?,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 29);
			insertState.setInt(2, 16);
			insertState.setString(3, "���ν����");
			insertState.setDouble(4, 4.8);
			insertState.setString(5, "�ε巯�� ũ���� �ö� Ŀ��");
			
			int rowsinsert = insertState.executeUpdate();
			System.out.println(rowsinsert + "row ������");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
