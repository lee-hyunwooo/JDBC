package com.kh.updateBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankModel {

	private static Connection connection;
	private static BankModel bankmodel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khbank";
	private static String PW = "kh1234";
	
	private BankModel() {
		
	}
	public static BankModel getInstance() throws SQLException {
		if(bankmodel == null) {
			bankmodel = new BankModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
		}
		return bankmodel;
	}
	public boolean updateBank(BankDTO bank) {
		String sql = "UPDATE BANK SET BALANCE = ? WHERE ACCOUNT_ID = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setDouble(1, bank.getBalance());
			st.setInt(2, bank.getACCOUNT_ID());
			
			int a = st.executeUpdate();
			return a > 0;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
	
	}
	
}
