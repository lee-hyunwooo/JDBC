package com.kh.Update;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateProductView {

	public void updateProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정하실 제품의 정보를 입력하세요");

		System.out.println("수정하실 제품의 ID를 입력해주세요");
		int product_id = sc.nextInt();
		System.out.println("수정하실 제품의 가격을 입력해주세요");
		double price = sc.nextDouble();
		
		//스캐너로 받은 제품 내용을 수정하기
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
		System.out.println("제품 수정이 성공적으로 되었습니다.");
	} else {
		System.out.println("제품 수정 중 오류가 발생했습니다.");
	}
	sc.close();
	}
}
