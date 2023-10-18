package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//cafes insert �ۼ��ؼ� ���� ī�� �߰��ϱ�

public class insertExam {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String passwore = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, passwore);
			String insertSQL = "INSERT INTO cafes (CAFE_ID, CNAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS)"
							+ "VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			insertCafes(ps, 42, "��Ŀ��", "����� ���� ������ 12", "010-555-7777", "���� 08:30-20:30");
			insertCafes(ps, 43, "Ŀ��Ŀ��", "����� ���� ������ 13", "010-666-7777", "��-�� 09:00-21:00");
			insertCafes(ps, 44, "��", "����� ���� ������ 14", "010-777-8888", "��-�� 08:00-20:30");
			ps.close();
			System.out.println("������ ���� �Ϸ�");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		static void insertCafes (PreparedStatement ps, int CAFE_ID, String CNAME, String ADDRESS, String PHONE_NUMBER, String OPERATING_HOURS) throws SQLException {		
		
		ps.setInt(1, CAFE_ID);
		ps.setString(2, CNAME);
		ps.setString(3, ADDRESS);
		ps.setString(4, PHONE_NUMBER);
		ps.setString(5, OPERATING_HOURS);
		
		ps.executeUpdate();
	}


}
