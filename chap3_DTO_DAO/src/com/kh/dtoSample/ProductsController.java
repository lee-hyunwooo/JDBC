package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

//모델과 뷰를 연결해주는 중간다리

public class ProductsController {
	//필드
	private ProductsModel productmodel; //모델 멤버변수
	private ProductsView productview;	//뷰 멤버변수

	//파라미터를 작성한 생성자
	public ProductsController(Connection con, ProductsView view) {
		this.productmodel = new ProductsModel(con);
		this.productview = view;
	}
	
	//출력메서드
	public void displayAllProducts() {
		List<ProductsDTO> products = productmodel.getProducts();
		productview.displayProducts(products);
	}
}
