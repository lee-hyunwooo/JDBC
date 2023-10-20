package com.kh.viewSample;

import java.util.List;

import com.kh.dtoSample.ProductDTO;

public class ProductView {

	public void displayProducts(List<ProductDTO> products) {
		for (ProductDTO p : products) {
			System.out.println("Product Id : " + p.getProductId());
			System.out.println("Product Name : " + p.getProductName());
			System.out.println("Category : " + p.getCategory());
			System.out.println("Price : " + p.getPrice());
			System.out.println("StockQuantity" + p.getStockQuantity());
			System.out.println("");
		}
	}
}
