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
		//1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. 오라클 내 컴퓨터 연결 : 데이터 베이스 연결 정보
		//thin이 드라이버의 역할을 함          나의 IP주소:포트번호:SID
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		try {
			//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터 베이스 연결 성공!");
			
			//SELECT 쿼리
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			 //result.next() : result 객체에서 다음 행(row)으로 이동
			//다음행이 있으면 true 반환, 그렇지 않으면 false 반환
			
			//값 존재 여부
			if(!result.isBeforeFirst()) {
				System.out.println("존재하는 데이터가 없습니다.");
			}
			while(result.next()) {
				//khbank에 있는 bank 테이블 결과집합에서 account_id를 가져옴
				int accountID = result.getInt("account_id");
				//1.함께해보기 : accountNumber
				int accountNumber = result.getInt("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2.함께해보기 : branchName
				String branchName = result.getString("branch_name");
				//java.sql import Date lastTransactionDate가져오기
				Date lastTransactionDate = result.getDate("last_transaction_date");
				System.out.println("ID : " + accountID + ", NAME : " + accountName + ", balance : " + balance + ", account_number : " + accountNumber + ", branch_Name : " + branchName+ ", lastTransctionDate : " + lastTransactionDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	static void selectKhcafe() {
			//1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
			String driver = "oracle.jdbc.driver.OracleDriver";
			//2. 오라클 내 컴퓨터 연결 : 데이터 베이스 연결 정보
			//                               나의 IP주소:포트번호:SID
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "khcafe";
			String password = "kh1234";
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, user, password);
				System.out.println("데이터 베이스 연결 성공!");
				//SELECT 쿼리
				//select * from menu 작성해서 menu table 가져오기
				String selectQuery = "select * from menu";
				PreparedStatement selectState = con.prepareStatement(selectQuery);
				ResultSet result = selectState.executeQuery();
				 //result.next() : result 객체에서 다음 행(row)으로 이동
				//다음행이 있으면 true 반환, 그렇지 않으면 false 반환
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
			//where절 추가해서 조건 추가                             유동적으로 설정하기 위해 "?"
			String selectQuery = "SELECT * FROM BANK WHERE account_id=?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			//여기에 원하는 조건의 account_id 설정
			int targetAID = 1;
			
			//조건 설정
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
			  System.out.println("조건에 해당하는 데이터가 없습니다.");
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
			//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(url, user, password);
			
			System.out.println("데이터 베이스 연결 성공!");
			
			//SELECT 쿼리
			//String selectQuery = "SELECT * FROM BANK WHERE account_number in(?,?)";
			String selectQuery = "SELECT * FROM BANK WHERE account_number in (?,?,?)";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			String[] targerAN = {"1234567890","1236777888","5555666777"};
			selectState.setString(1, targerAN[0]); //(출력순서, 인덱스값)
			selectState.setString(2, targerAN[1]);
			selectState.setString(3, targerAN[2]);
			ResultSet result = selectState.executeQuery();
			 //result.next() : result 객체에서 다음 행(row)으로 이동
			//다음행이 있으면 true 반환, 그렇지 않으면 false 반환
			while(result.next()) {
				//khbank에 있는 bank 테이블 결과집합에서 account_id를 가져옴
				int accountID = result.getInt("account_id");
				//1.함께해보기 : accountNumber
				long accountNumber = result.getLong("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2.함께해보기 : branchName
				String branchName = result.getString("branch_name");
				//java.sql import Date lastTransactionDate가져오기
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
			//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(url, user, password);
			
			System.out.println("데이터 베이스 연결 성공!");
			//SELECT 쿼리
			//String selectQuery = "SELECT * FROM BANK WHERE account_number in(?,?)";
			//                                                                 (?)갯수만큼 검색가능하며, 검색된 갯수만큼 출력됌
			String selectQuery = "SELECT * FROM BANK WHERE account_name in (?,?,?)";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			String[] targerAN = {"가나다","김영희","이동훈"};
			selectState.setString(1, targerAN[0]); //(출력순서, 인덱스값)
			selectState.setString(2, targerAN[1]);
			selectState.setString(3, targerAN[2]);
			ResultSet result = selectState.executeQuery();
			 //result.next() : result 객체에서 다음 행(row)으로 이동
			//다음행이 있으면 true 반환, 그렇지 않으면 false 반환
			while(result.next()) {
				//khbank에 있는 bank 테이블 결과집합에서 account_id를 가져옴
				int accountID = result.getInt("account_id");
				//1.함께해보기 : accountNumber
				long accountNumber = result.getLong("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2.함께해보기 : branchName
				String branchName = result.getString("branch_name");
				//java.sql import Date lastTransactionDate가져오기
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
			System.out.println("연결성공");
			
			String selectQurty = "SELECT * FROM CAFES WHERE operating_hours in (?,?)";
			PreparedStatement selectState = con.prepareStatement(selectQurty);
			
			String[] targethours = {"매일: 07:00-20:30", "매일: 09:30-20:00"};
			selectState.setString(1, targethours[0]);
			selectState.setString(2, targethours[1]);
			
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				//khbank에 있는 bank 테이블 결과집합에서 account_id를 가져옴
				int CAFEID = result.getInt("CAFE_ID");
				//1.함께해보기 : accountNumber
				String CNAME = result.getString("CNAME");
				String address = result.getString("address");
				String PhoneNumber = result.getString("PHONE_NUMBER");
				//2.함께해보기 : branchName
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
			insertState.setString(3, "사아자");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5,  "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row 추가됨");
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
			//insert문 작성해보기
			String insertQuery = "INSERT INTO CAFES (CAFE_ID, CNAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS)"
								+ "VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 41);
			insertState.setString(2, "커피청");
			insertState.setString(3, "서울시 은평구 연서로 11");
			insertState.setString(4, "000-888-7777");
			insertState.setString(5, "매일 : 09:00-20:30");
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row 추가됌");
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
			insertState.setString(3, "토피넛라떼");
			insertState.setDouble(4, 3.80);
			insertState.setString(5, "고소한 풍미의 라떼");
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row 추가됌");
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
			insertState.setString(3, "아포가토");
			insertState.setDouble(4, 5.30);
			insertState.setString(5, "부드러운 아이스크림이 올라간 커피");
			
			int rowsinto = insertState.executeUpdate();
			System.out.println(rowsinto + "row 생성됌");
			
			
			
			
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
			insertState.setString(3, "아인슈페너");
			insertState.setDouble(4, 4.8);
			insertState.setString(5, "부드러운 크림이 올라간 커피");
			
			int rowsinsert = insertState.executeUpdate();
			System.out.println(rowsinsert + "row 생성됌");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
