package com.kh.ControllerSample;

import java.sql.Connection;
import java.util.List;

import com.kh.dtoSample.ProductDTO;
import com.kh.modelSample.ProductModel;
import com.kh.viewSample.ProductView;

//모델과 뷰를 연결해주는 중간다리

public class ProductController {
	//필드
	private ProductModel productmodel; //모델 멤버변수
	private ProductView productview;	//뷰 멤버변수

	//파라미터를 작성한 생성자
	public ProductController(Connection con, ProductView view) {
		this.productmodel = new ProductModel(con);
		this.productview = view;
	}
	
	//출력메서드
	public void displayAllProducts() {
		List<ProductDTO> products = productmodel.getProducts();
		productview.displayProducts(products);
	}
}
