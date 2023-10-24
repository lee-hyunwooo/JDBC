package com.kh.updateBank;

import java.sql.SQLException;
import java.util.Scanner;

public class BankView {

	public void updateBank() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�����Ͻ� ID�� �Է����ּ���");
		int account_id = sc.nextInt();
		System.out.println("�����Ͻ� balance�� �Է����ּ���");
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
			System.out.println("������ �Ϸ�Ǿ����ϴ�");
		}else {
			System.out.println("������ �����߽��ϴ�.");
		}
		//�ݴ� ���� 1. ��� ���� �ݱ�(ResultSet) 2. sql���� �ݱ� (PreparedStatement) 3. sql �ݱ�(Connection) 4.Scanner
		sc.close();
	
	}
	
	
	
}
