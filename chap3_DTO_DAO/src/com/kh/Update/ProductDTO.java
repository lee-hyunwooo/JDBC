package com.kh.Update;

public class ProductDTO {
	//model sql 열 형식에 맞춰 데이터를 캡슐화하고 getter setter를 활용하여 데이터를 저정하고 내보내는 공간

	//필드 멤버변수 작성
	private double price;
	private int product_id;

	//생성자
	//1. 기본 생성자
	public ProductDTO() {
		 
	}
	
	//2파라미터 값을 받을 생성자
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
