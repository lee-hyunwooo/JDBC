package com.kh.Update;

public class ProductDTO {
	//model sql �� ���Ŀ� ���� �����͸� ĸ��ȭ�ϰ� getter setter�� Ȱ���Ͽ� �����͸� �����ϰ� �������� ����

	//�ʵ� ������� �ۼ�
	private double price;
	private int product_id;

	//������
	//1. �⺻ ������
	public ProductDTO() {
		 
	}
	
	//2�Ķ���� ���� ���� ������
	public ProductDTO(double price, int product_id) {
		this.price = price;
		this.product_id = product_id;
	}
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

}
