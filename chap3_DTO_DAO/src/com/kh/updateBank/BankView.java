package com.kh.updateBank;

import java.sql.SQLException;
import java.util.Scanner;

public class BankView {

	public void updateBank() {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정하실 ID를 입력해주세요");
		int account_id = sc.nextInt();
		System.out.println("수정하실 balance를 입력해주세요");
		double balance = sc.nextDouble();
		
		BankDTO newBank = new BankDTO (account_id, balance);
		BankModel bankModel;
		
		boolean success = false;
				
		try {
			bankModel = BankModel.getInstance();
			success = bankModel.updateBank(newBank);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success) {
			System.out.println("수정이 완료되었습니다");
		}else {
			System.out.println("수정이 실패했습니다.");
		}
		//닫는 순서 1. 결과 집합 닫기(ResultSet) 2. sql연결 닫기 (PreparedStatement) 3. sql 닫기(Connection) 4.Scanner
		sc.close();
	
	}
	
	
	
}
