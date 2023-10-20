package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

//�𵨰� �並 �������ִ� �߰��ٸ�

public class ProductsController {
	//�ʵ�
	private ProductsModel model; //�� �������
	private ProductsView view;	//�� �������

	//�Ķ���͸� �ۼ��� ������
	public ProductsController(Connection con, ProductsView view) {
		this.model = new ProductsModel(con);
		this.view = view;
	}
	
	//��¸޼���
	public void displayAllProducts() {
		List<ProductsDTO> products = model.getProducts();
		view.displayProducts(products);
	}
}
