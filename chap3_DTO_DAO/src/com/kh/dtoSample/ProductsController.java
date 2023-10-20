package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

//�𵨰� �並 �������ִ� �߰��ٸ�

public class ProductsController {
	//�ʵ�
	private ProductsModel productmodel; //�� �������
	private ProductsView productview;	//�� �������

	//�Ķ���͸� �ۼ��� ������
	public ProductsController(Connection con, ProductsView view) {
		this.productmodel = new ProductsModel(con);
		this.productview = view;
	}
	
	//��¸޼���
	public void displayAllProducts() {
		List<ProductsDTO> products = productmodel.getProducts();
		productview.displayProducts(products);
	}
}
