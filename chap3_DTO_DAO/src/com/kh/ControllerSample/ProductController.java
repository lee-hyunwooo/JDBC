package com.kh.ControllerSample;

import java.sql.Connection;
import java.util.List;

import com.kh.dtoSample.ProductDTO;
import com.kh.modelSample.ProductModel;
import com.kh.viewSample.ProductView;

//�𵨰� �並 �������ִ� �߰��ٸ�

public class ProductController {
	//�ʵ�
	private ProductModel productmodel; //�� �������
	private ProductView productview;	//�� �������

	//�Ķ���͸� �ۼ��� ������
	public ProductController(Connection con, ProductView view) {
		this.productmodel = new ProductModel(con);
		this.productview = view;
	}
	
	//��¸޼���
	public void displayAllProducts() {
		List<ProductDTO> products = productmodel.getProducts();
		productview.displayProducts(products);
	}
}
