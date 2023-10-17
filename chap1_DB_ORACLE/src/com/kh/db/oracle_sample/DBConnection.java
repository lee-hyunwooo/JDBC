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
		//1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. 오라클 내 컴퓨터 연결 : 데이터 베이스 연결 정보
		//                               나의 IP주소:포트번호:SID
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
}
