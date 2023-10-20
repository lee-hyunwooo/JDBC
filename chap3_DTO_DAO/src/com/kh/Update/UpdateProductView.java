package com.kh.Update;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateProductView {

	public void updateProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�����Ͻ� ��ǰ�� ������ �Է��ϼ���");

		System.out.println("�����Ͻ� ��ǰ�� ID�� �Է����ּ���");
		int product_id = sc.nextInt();
		System.out.println("�����Ͻ� ��ǰ�� ������ �Է����ּ���");
		double price = sc.nextDouble();
		
		//��ĳ�ʷ� ���� ��ǰ ������ �����ϱ�
		ProductDTO newProduct = new ProductDTO (price, product_id);
		UpdateProductModel productModel;
		
		boolean success = false;
	try {
		productModel = UpdateProductModel.getInstance();
		success =productModel.updeateProduct(newProduct);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(success) {
		System.out.println("��ǰ ������ ���������� �Ǿ����ϴ�.");
	} else {
		System.out.println("��ǰ ���� �� ������ �߻��߽��ϴ�.");
	}
	sc.close();
	}
}
