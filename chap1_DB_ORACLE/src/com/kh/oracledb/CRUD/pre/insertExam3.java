package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import oracle.sql.DATE;

public class insertExam3 {

	public static void main(String[] args) throws SQLException {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "BOOK";
		String passwore = "kh1234";
		
		
			Connection con = DriverManager.getConnection(jdbcUrl, userName, passwore);
			String insertSQL = "INSERT INTO BOOK (BOOK_ID, TITLE, AUTHOR,PUBLICATION_YEAR, ISBN, GENRE, DESCRIPTION, PRICE, PUBLICATION_DATE,IS_AVAILABLE)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			ps.setInt(1, 32);
			ps.setString(2, "위대한 KH");
			ps.setString(3, "KH");
			ps.setInt(4, 2023);
			ps.setString(5, "978-1234567891");
			ps.setString(6, "소설");
			ps.setString(7, "위대한 교육 소설");
			ps.setDouble(8, 9.99);
			ps.setString(10, "Y");
			
			Date publicationDate = Date.valueOf("1936-01-01");
			ps.setDate(9, new Date(publicationDate.getTime()));
			int rows = ps.executeUpdate();
			System.out.println(rows + "도서가 저장되었습니다");
			System.out.println("도서 저장 완료");
		
			
		

	}

	
}
