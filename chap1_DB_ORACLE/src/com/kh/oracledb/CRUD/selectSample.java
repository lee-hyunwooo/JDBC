package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.sql.DATE;

import java.sql.Date;
public class selectSample {

	public static void main(String[] args) {
		//selectAll();
		//selectOne();
	
	}
			
	static void selectAll() {
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

	static void selectOne() {
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


}
